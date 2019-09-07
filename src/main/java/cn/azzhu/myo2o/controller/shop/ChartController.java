package cn.azzhu.myo2o.controller.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author azzhu
 * @create 2019-08-26 18:56:14
 */
@Controller
@RequestMapping("/shop/chart")
public class ChartController {

    @GetMapping("/top5.html")
    public String toTop5() {
        return "shop/chart/top5";
    }

    @GetMapping("/order.html")
    public String toOrder() {
        return "shop/chart/order";
    }

    @GetMapping("/money.html")
    public String toMoney() {
        return "shop/chart/money";
    }


    @GetMapping("top5")
    @ResponseBody
    public Object getTop5Data() {
        //从订单表中明细表中，按照商品id，汇总统计
        return null;
    }
}
