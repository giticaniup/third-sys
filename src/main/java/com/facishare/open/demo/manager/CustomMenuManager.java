package com.facishare.open.demo.manager;

import com.facishare.open.demo.beans.results.BaseResult;
import com.facishare.open.demo.beans.results.CustomMenuResult;
import com.facishare.open.demo.beans.results.OpenMenu;
import com.facishare.open.demo.exception.AccessTokenException;

import java.util.List;

/**
 * 自定义菜单接口
 * Created by zhongcy on 2016/5/17.
 */
public interface CustomMenuManager {

    /**
     * 获取自定义菜单
     */
    CustomMenuResult getCustomMenuList() throws AccessTokenException;

    /**
     * 设置菜单状态
     * @param status 状态:NORMAL、CLOSE、DELETED
     * @return  返回是否成功
     * @throws AccessTokenException
     */
    BaseResult setMenuStatus(String status)throws AccessTokenException;

    /**
     * 设置自定义菜单
     * @param menu 菜单
     * @return     返回是否设置成功
     * @throws AccessTokenException
     */
    BaseResult setCustomMenu(List<OpenMenu> menu) throws AccessTokenException;
}
