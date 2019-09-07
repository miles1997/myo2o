package cn.azzhu.myo2o.controller.shop;

import cn.azzhu.myo2o.exception.O2OException;
import cn.azzhu.myo2o.utils.*;
import cn.azzhu.myo2o.entity.LocalAuth;
import cn.azzhu.myo2o.entity.Product;
import cn.azzhu.myo2o.entity.ShopAuthMap;
import cn.azzhu.myo2o.service.ProductService;
import cn.azzhu.myo2o.service.impl.ShopAuthServiceImpl;
import cn.azzhu.myo2o.vo.ProductVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author azzhu
 * @create 2019-08-26 13:07:09
 */
@Controller
@RequestMapping("/shop/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ShopAuthServiceImpl shopAuthService;

    /**
     * 跳转到商品列表页面
     * @return
     */
    @GetMapping("/list.html")
    public String toList() {
        return "shop/product/list";
    }

    /**
     * 带查询条件的分页
     * @param productVo
     * @param session
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object getList(ProductVo productVo, HttpSession session,
                          @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                          @RequestParam(value = "limit",required = false,defaultValue = "5") Integer limit) {
        //查询出当前登录人，然后用userId去shop_auth_map表中查询当前登录人有哪些shopid
        LocalAuth user = (LocalAuth) session.getAttribute(SysContants.SESSION_USER);
        List<ShopAuthMap> userShops = shopAuthService.getShopsByAuthId(user);

        //设置productVO的shops
        ArrayList<Long> shopIds = new ArrayList<>();
        for (ShopAuthMap userShop : userShops) {
            shopIds.add(userShop.getShopId());
        }
        productVo.setShopIds(shopIds);
        PageInfo<Product> pageInfo = productService.getPage(page, limit, productVo);
        DataGridView<Product> dataGridView = new DataGridView<>();

        //设置pageResultDTO参数值
        dataGridView.setCount(pageInfo.getTotal());
        dataGridView.setData(pageInfo.getList());
        return dataGridView;
    }

    /**
     * 删除单个商品
     * @param product
     * @return
     */
    @GetMapping("deleteProduct")
    @ResponseBody
    public Object deleteProduct(Product product) {
        try {
            this.productService.deleteProductById(product);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("deleteBatchProduct")
    @ResponseBody
    public ResultObj deleteBatchProduct(String[] ids) {
        try {
            this.productService.deleteProductByIds(ids);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 下架商品
     * @param product
     * @return
     */
    @GetMapping("down")
    @ResponseBody
    public ResultObj down(Product product) {
        try {
            this.productService.down(product);
            return ResultObj.DOWN_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DOWN_ERROR;
        }
    }

    /**
     * 上架商品
     * @param product
     * @return
     */
    @GetMapping("up")
    @ResponseBody
    public ResultObj up(Product product) {
        try {
            this.productService.up(product);
            return ResultObj.UP_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UP_ERROR;
        }
    }

    /**
     * 添加商品
     * @param product
     * @return
     */
    @PostMapping("addProduct")
    @ResponseBody
    public ResultObj addProduct(Product product) {
        //设置时间
        product.setCreateTime(new Date());
        product.setLastEditTime(new Date());

        try {
            //如果不是默认图片就去掉图片的_temp的后缀
            if(!product.getImgAddr().equals(SysContants.DEFAULT_PRODUCT_IMG)) {
                String filePath=AppFileUtils.updateFileName(product.getImgAddr(),SysContants.FILE_UPLOAD_TEMP);
                product.setImgAddr(filePath);
            }
            productService.addProduct(product);
            return ResultObj.ADD_SUCCESS;
        } catch (O2OException e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改商品
     * @param product
     * @return
     */
    @PostMapping("updateProduct")
    @ResponseBody
    public ResultObj updateProduct(Product product) {
        //设置修改时间
        product.setLastEditTime(new Date());

        try {
            //如果不是默认图片就去掉图片的_temp的后缀
            if(!product.getImgAddr().equals(SysContants.DEFAULT_PRODUCT_IMG)) {
                String filePath=AppFileUtils.updateFileName(product.getImgAddr(),SysContants.FILE_UPLOAD_TEMP);
                product.setImgAddr(filePath);
            }
            productService.updateProduct(product);
            return ResultObj.UPDATE_SUCCESS;
        } catch (O2OException e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
}
