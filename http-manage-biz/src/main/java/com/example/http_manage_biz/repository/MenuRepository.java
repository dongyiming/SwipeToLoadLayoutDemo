package com.example.http_manage_biz.repository;


import com.example.http_manage_biz.greendao.MenuInfoDao;
import com.example.http_manage_biz.vo.MenuInfo;

import java.util.List;

/**
 * @version : 1.0
 * @Description : 歌单数据操作
 * @autho : dongyiming
 * @data : 2017/7/10 21:13
 */
public class MenuRepository extends BaseRepository<MenuInfo> implements IMenuRepository {

    private MenuInfoDao menuInfoDao;

    public MenuRepository() {
        super();
        menuInfoDao = daoSession.getMenuInfoDao();
    }

    /**
     * 添加
     *
     * @param menuInfo
     */
    @Override
    public void addOrUpdate(MenuInfo menuInfo) {

        MenuInfo menu = selectById(menuInfo.getMenuCode());
        if (menu != null) {
            updateItem(menuInfo);
        } else {
            insertItem(menuInfo);
        }
    }

    @Override
    public void insert(MenuInfo menuInfo) {
        insertItem(menuInfo);
    }

    /**
     * 插入多条数据
     *
     * @param menuInfos
     * @return
     */
    @Override
    public boolean insertList(final List<MenuInfo> menuInfos) {

        boolean flag;
        if (menuInfos == null || menuInfos.isEmpty()) {
            return false;
        }
        try {
            daoSession.getMenuInfoDao().insertInTx(menuInfos);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public MenuInfo selectById(int menuInfoCode) {

        MenuInfo menuInfo = menuInfoDao.queryBuilder().where(MenuInfoDao.Properties.MenuCode.eq(menuInfoCode)).build().unique();
        return menuInfo;
    }

    @Override
    public List<MenuInfo> selectByType(int menuType) {

        List<MenuInfo> menuInfos = menuInfoDao.queryBuilder().where(MenuInfoDao.Properties.MenuType.eq(menuType)).list();
        if (menuInfos != null && menuInfos.size() != 0) {
            return menuInfos;
        }
        return null;
    }

}
