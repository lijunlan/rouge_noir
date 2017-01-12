package com.sdll18.rougenoir.be.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sdll18.rougenoir.be.constant.Code;
import com.sdll18.rougenoir.be.mapper.RnUserMapper;
import com.sdll18.rougenoir.be.model.RnUser;
import com.sdll18.rougenoir.be.service.RnUserService;
import com.sdll18.rougenoir.be.util.FastJsonUtil;
import com.sdll18.rougenoir.be.util.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Locale;

/**
 * Copyright (C) 2015 - 2017 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2017-01-12
 */
@Service
public class RnUserServiceImpl implements RnUserService {

    private static final Logger logger = Logger.getLogger(RnUserServiceImpl.class);

    @Autowired
    private RnUserMapper rnUserMapper;

    @Override
    public JSONObject findUserById(Integer id) {
        try {
            RnUser rnUser = rnUserMapper.selectByPrimaryKey(id);
            if (rnUser == null) {
                return FastJsonUtil.error(Code.ERROR_ID_NOT_EXISTED, "user id is not existed");
            }
            return FastJsonUtil.success(rnUser);
        } catch (Exception e) {
            logger.error("failed to find use by id", e);
            return FastJsonUtil.errorInternal();
        }
    }

    @Override
    public JSONObject login(JSONObject jsonObject) {
        try {
            RnUser rnUser = JSON.toJavaObject(jsonObject, RnUser.class);
            String username = rnUser.getUsername();
            String password = rnUser.getPassword();
            password = MD5Util.doubleMD5(password);
            rnUser = rnUserMapper.selectByUsernameAndPwd(username, password);
            if (rnUser == null) {
                return FastJsonUtil.error(Code.ERROR_LOGIN_FAILED, "username or password is not accurate");
            }
            return FastJsonUtil.success(rnUser);
        } catch (Exception e) {
            logger.error("failed to login", e);
            return FastJsonUtil.errorInternal();
        }
    }

    @Override
    public JSONObject register(JSONObject jsonObject) {
        try {
            RnUser rnUser = JSON.toJavaObject(jsonObject, RnUser.class);
            rnUser.setCreateTime(Calendar.getInstance(Locale.CHINA).getTime());
            rnUser.setPassword(MD5Util.doubleMD5(rnUser.getPassword()));
            rnUser.setStatus(0);
            int r = rnUserMapper.insert(rnUser);
            JSONObject result = new JSONObject();
            result.put("id", r);
            return FastJsonUtil.success(result);
        } catch (Exception e) {
            logger.error("failed to register", e);
            return FastJsonUtil.errorInternal();
        }
    }

    @Override
    public JSONObject updateInfo(JSONObject jsonObject) {
        try {
            RnUser rnUser = JSON.toJavaObject(jsonObject, RnUser.class);
            rnUser.setUpdateTime(Calendar.getInstance(Locale.CHINA).getTime());
            rnUserMapper.updateByPrimaryKey(rnUser);
            return FastJsonUtil.success();
        } catch (Exception e) {
            logger.error("failed to update", e);
            return FastJsonUtil.errorInternal();
        }
    }
}
