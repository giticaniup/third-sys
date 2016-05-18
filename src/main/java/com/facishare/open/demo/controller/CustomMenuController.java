package com.facishare.open.demo.controller;

import com.facishare.open.demo.beans.args.SetMenuArg;
import com.facishare.open.demo.beans.results.BaseResult;
import com.facishare.open.demo.beans.results.CustomMenuResult;
import com.facishare.open.demo.beans.results.OpenMenu;
import com.facishare.open.demo.exception.AccessTokenException;
import com.facishare.open.demo.manager.CustomMenuManager;
import com.google.common.base.Splitter;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 自定义菜单Controller
 * Created by zhongcy on 2016/5/17.
 */
@RestController
@RequestMapping(value = "/customMenu", produces = "application/json")
public class CustomMenuController {

    private static final Logger logger = LoggerFactory.getLogger(CustomMenuController.class);

    private Gson gson = new Gson();

    @Autowired
    private CustomMenuManager customMenuManager;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public CustomMenuResult getCustomMenuList() {
        CustomMenuResult result;

        try {
            result = customMenuManager.getCustomMenuList();
        } catch (AccessTokenException e) {
            logger.error("getCustomMenuList access token error, details:{}", e.getMessage());
            result = new CustomMenuResult();
            result.setErrorCode(e.getCode());
            result.setErrorMessage(e.getMessage());
        }

        return result;
    }

    @RequestMapping(value = "/menu/{status}", method = RequestMethod.PUT)
    public BaseResult setCustomStatus(@PathVariable("status") String status) {
        BaseResult result;

        try {
            result = customMenuManager.setMenuStatus(status);
        } catch (AccessTokenException e) {
            logger.error("setCustomStatus access token error, details:{}", e.getMessage());
            result = new CustomMenuResult();
            result.setErrorCode(e.getCode());
            result.setErrorMessage(e.getMessage());
        }

        return result;
    }

    @RequestMapping(value = "/menu/set", method = RequestMethod.POST)
    public BaseResult setCustomMenu( @RequestBody SetMenuArg setMenuArg){
        BaseResult result;
        try {
            result = customMenuManager.setCustomMenu(setMenuArg.getMenus());
        } catch (AccessTokenException e) {
            logger.error("setCustomMenu access token error, details:{}", e.getMessage());
            result = new CustomMenuResult();
            result.setErrorCode(e.getCode());
            result.setErrorMessage(e.getMessage());
        }
        return result;
    }
}
