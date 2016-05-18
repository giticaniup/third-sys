package com.facishare.open.demo.beans.results;

import com.google.common.base.MoreObjects;

import java.util.List;

/**
 * 获取自定义菜单返回结果
 * Created by zhongcy on 2016/5/17.
 */
public class CustomMenuResult extends BaseResult {
    private static final long serialVersionUID = 4623929906033415367L;
    /**
     * 菜单状态
     */
    private String status;


    /**
     * 菜单
     */
    private List<OpenMenu> menus;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OpenMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<OpenMenu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("errorCode", errorCode)
                .add("errorMessage", errorMessage)
                .add("status", status)
                .add("menus", menus)
                .toString();
    }
}
