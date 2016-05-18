package com.facishare.open.demo.beans.args;

import com.google.common.base.MoreObjects;

/**
 * 设置菜单状态
 * Created by zhongcy on 2016/5/17.
 */
public class SetMenuStatusArg implements Arg{
    private static final long serialVersionUID = 5616792268721934951L;

    /**
     * appAccessToken
     */
    private String appAccessToken;

    /**
     * 菜单状态，可以是NORMAL/CLOSE/DELETED
     */
    private String status;

    public String getAppAccessToken() {
        return appAccessToken;
    }

    public void setAppAccessToken(String appAccessToken) {
        this.appAccessToken = appAccessToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("appAccessToken", appAccessToken)
                .add("status", status)
                .toString();
    }
}
