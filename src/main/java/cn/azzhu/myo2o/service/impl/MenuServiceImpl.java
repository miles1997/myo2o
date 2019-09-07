package cn.azzhu.myo2o.service.impl;

import cn.azzhu.myo2o.entity.Menu;
import cn.azzhu.myo2o.mapper.sys.MenuMapper;
import cn.azzhu.myo2o.service.MenuService;
import cn.azzhu.myo2o.utils.DataGridView;
import cn.azzhu.myo2o.vo.MenuVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author azzhu
 * @create 2019-09-03 23:12:02
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> queryAllMenuForList(MenuVo menuVo) {
        return menuMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userId) {
        return null;
    }

    @Override
    public DataGridView queryAllMenu(MenuVo menuVo) {
        return null;
    }

    @Override
    public void addMenu(MenuVo menuVo) {

    }

    @Override
    public void updateMenu(MenuVo menuVo) {

    }

    @Override
    public Integer queryMenuByPid(Integer pid) {
        return null;
    }

    @Override
    public void deleteMenu(MenuVo menuVo) {

        //删除菜单表的数据
        this.menuMapper.deleteById(menuVo.getId());

        //根据菜单id删除sys_role_menu里面的数据
        //this.menuMapper.deleteRoleMenuByMid(menuVo.getId());
    }
}
