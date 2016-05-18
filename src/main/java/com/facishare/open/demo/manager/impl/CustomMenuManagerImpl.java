package com.facishare.open.demo.manager.impl;

import com.facishare.open.demo.beans.args.CustomMenuArg;
import com.facishare.open.demo.beans.args.SetMenuArg;
import com.facishare.open.demo.beans.args.SetMenuStatusArg;
import com.facishare.open.demo.beans.results.BaseResult;
import com.facishare.open.demo.beans.results.CustomMenuResult;
import com.facishare.open.demo.beans.results.OpenMenu;
import com.facishare.open.demo.exception.AccessTokenException;
import com.facishare.open.demo.manager.AccessTokenManager;
import com.facishare.open.demo.manager.CustomMenuManager;
import com.facishare.open.demo.utils.OpenAPIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 自定义菜单接口实现类
 * Created by zhongcy on 2016/5/17.
 */
@Service("customMenuManager")
public class CustomMenuManagerImpl implements CustomMenuManager{

    private static final Logger logger = LoggerFactory.getLogger(CustomMenuManagerImpl.class);

    @Autowired
    private AccessTokenManager accessTokenManager;

    @Override
    public CustomMenuResult getCustomMenuList() throws AccessTokenException {
        CustomMenuArg customMenuArg = new CustomMenuArg();
        String appAccessToken = accessTokenManager.getAppAccessToken();
        customMenuArg.setAppAccessToken(appAccessToken);
        return OpenAPIUtils.getMenuList(customMenuArg);
    }

    @Override
    public BaseResult setMenuStatus(String status) throws AccessTokenException {
        SetMenuStatusArg setMenuStatusArg = new SetMenuStatusArg();
        setMenuStatusArg.setAppAccessToken(accessTokenManager.getAppAccessToken());
        setMenuStatusArg.setStatus(status);
        return OpenAPIUtils.setMenuStatus(setMenuStatusArg);
    }

    @Override
    public BaseResult setCustomMenu(List<OpenMenu> menu) throws AccessTokenException {
        SetMenuArg setMenuArg = new SetMenuArg();
        setMenuArg.setAppAccessToken(accessTokenManager.getAppAccessToken());
        setMenuArg.setMenus(menu);
        return OpenAPIUtils.setCustomMenu(setMenuArg);
    }
}
