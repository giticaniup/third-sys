package com.facishare.open.demo.beans.args;

import com.google.common.base.MoreObjects;

/**
 * 获取自定义菜单参数
 * Created by zhongcy on 2016/5/17.
 */
public class CustomMenuArg implements Arg {
    private static final long serialVersionUID = 663227887152873860L;

    /**
     * 第三方应用访问授权码
     */
    private String appAccessToken;

    public String getAppAccessToken() {
        return appAccessToken;
    }

    public void setAppAccessToken(String appAccessToken) {
        this.appAccessToken = appAccessToken;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("appAccessToken", appAccessToken)
                .toString();
    }
}
