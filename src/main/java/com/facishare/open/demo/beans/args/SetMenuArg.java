package com.facishare.open.demo.beans.args;

import com.facishare.open.demo.beans.results.OpenMenu;
import com.google.common.base.MoreObjects;

import java.util.List;

/**
 * 设置自定义状态
 * Created by zhongcy on 2016/5/18.
 */
public class SetMenuArg implements Arg {
    private static final long serialVersionUID = 7293749773567034494L;

    /**
     * 访问凭证
     */
    private String appAccessToken;

    private List<OpenMenu> menus;

    public String getAppAccessToken() {
        return appAccessToken;
    }

    public void setAppAccessToken(String appAccessToken) {
        this.appAccessToken = appAccessToken;
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
                .add("appAccessToken", appAccessToken)
                .add("menus", menus)
                .toString();
    }
}
