package cn.azzhu.myo2o.service;

import cn.azzhu.myo2o.entity.Menu;
import cn.azzhu.myo2o.utils.DataGridView;
import cn.azzhu.myo2o.vo.MenuVo;

import java.util.List;

/**
 * @author azzhu
 * @create 2019-09-03 23:08:09
 */
public interface MenuService {
    /**
     * 查询所有菜单返回
     * List<Menu>
     */
    public List<Menu> queryAllMenuForList(MenuVo menuVo);

    /**
     * 根据用户id查询用户的可用菜单
     */
    public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userId);

    /**
     * 查询所有菜单
     * @param menuVo
     * @return
     */
    public DataGridView queryAllMenu(MenuVo menuVo);

    /**
     * 添加菜单
     * @param menuVo
     */
    public void addMenu(MenuVo menuVo);

    /**
     * 修改菜单
     * @param menuVo
     */
    public void updateMenu(MenuVo menuVo);

    /**
     * 根据pid查询菜单数量
     * @param pid
     * @return
     */
    public Integer queryMenuByPid(Integer pid);

    /**
     * 根据id删除菜单
     * @param menuVo
     */
    public void deleteMenu(MenuVo menuVo);
}
