package com.example.http_manage_biz.vo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class MenuInfo {
    @Id(autoincrement = true)
    private Long id;

    private Integer menuCode;

    private String menuName;

    private String menuDesc;

    private Integer authorCode;

    private String authorName;

    private Integer menuType;//0:普通歌单 1：专辑歌单 2：推荐歌单  3：独家放送 4：最新音乐 5：推荐MV  6：精选专栏  7：主播电台

    private String menuPicurl;

    private Long playcount;

    private String createTime;

    private String updateTime;

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getPlaycount() {
        return this.playcount;
    }

    public void setPlaycount(Long playcount) {
        this.playcount = playcount;
    }

    public String getMenuPicurl() {
        return this.menuPicurl;
    }

    public void setMenuPicurl(String menuPicurl) {
        this.menuPicurl = menuPicurl;
    }

    public Integer getMenuType() {
        return this.menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getAuthorCode() {
        return this.authorCode;
    }

    public void setAuthorCode(Integer authorCode) {
        this.authorCode = authorCode;
    }

    public String getMenuDesc() {
        return this.menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuCode() {
        return this.menuCode;
    }

    public void setMenuCode(Integer menuCode) {
        this.menuCode = menuCode;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 546406352)
    public MenuInfo(Long id, Integer menuCode, String menuName, String menuDesc,
            Integer authorCode, String authorName, Integer menuType, String menuPicurl,
            Long playcount, String createTime, String updateTime) {
        this.id = id;
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuDesc = menuDesc;
        this.authorCode = authorCode;
        this.authorName = authorName;
        this.menuType = menuType;
        this.menuPicurl = menuPicurl;
        this.playcount = playcount;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Generated(hash = 859137273)
    public MenuInfo() {
    }

}