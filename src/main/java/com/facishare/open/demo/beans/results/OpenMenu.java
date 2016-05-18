package com.facishare.open.demo.beans.results;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 自定义菜单
 * Created by zhongcy on 2016/5/17.
 */
public class OpenMenu implements Serializable {
    private static final long serialVersionUID = -7771228751061315605L;
    /**
     * 自定义菜单名称
     */
    private String name;

    /**
     * 菜单类型
     * 1 响应消息 2 url跳转 3图文消息
     *
     * 为了方面对象与json的转换，不直接定义枚举
     */
    private int type = 0;

    /**
     * 参数
     * 如果type是1,则是响应消息
     * 为2,则为url地址
     */
    private String actionParam;

    /**
     * 子菜单
     */
    private List<OpenMenu> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getActionParam() {
        return actionParam;
    }

    public void setActionParam(String actionParam) {
        this.actionParam = actionParam;
    }

    public List<OpenMenu> getChildren() {
        return children;
    }

    public void setChildren(List<OpenMenu> children) {
        this.children = children;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.type, this.actionParam, this.children);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        OpenMenu other = (OpenMenu) obj;

        return Objects.equals(name, other.name) && Objects.equals(type, other.type)
                && Objects.equals(actionParam, other.actionParam) && Objects.equals(children, other.children);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).add("type", type).add("actionParam", actionParam)
                .add("children", children).toString();
    }
}
