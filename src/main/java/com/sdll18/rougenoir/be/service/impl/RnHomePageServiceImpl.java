package com.sdll18.rougenoir.be.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sdll18.rougenoir.be.mapper.RnHomePageMapper;
import com.sdll18.rougenoir.be.model.RnHomePage;
import com.sdll18.rougenoir.be.service.RnHomePageService;
import com.sdll18.rougenoir.be.util.FastJsonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * Copyright (C) 2015 - 2017 JUNLAN LI All Rights Reserved.
 *
 * @Author: lijunlan888@gmail.com
 * @Date: 2017-01-10
 */
@Service
public class RnHomePageServiceImpl implements RnHomePageService {

    private static final Logger logger = Logger.getLogger(RnHomePageServiceImpl.class);

    @Autowired
    private RnHomePageMapper rnHomePageMapper;

    @Override
    public JSONObject listItems() {
        try {
            List<RnHomePage> list = rnHomePageMapper.selectAll();
            return FastJsonUtil.success(list);
        } catch (Exception e) {
            logger.error("failed to list home page items", e);
            return FastJsonUtil.errorInternal();
        }
    }

    @Override
    public JSONObject findItem(Integer id) {
        try {
            RnHomePage rnHomePage = rnHomePageMapper.selectByPrimaryKey(id);
            return FastJsonUtil.success(rnHomePage);
        } catch (Exception e) {
            logger.error("failed to find home page item by id", e);
            return FastJsonUtil.errorInternal();
        }

    }

    @Transactional
    @Override
    public JSONObject updateItem(JSONObject jsonObject) {
        try {
            RnHomePage rnHomePage = JSON.toJavaObject(jsonObject, RnHomePage.class);
            rnHomePageMapper.updateByPrimaryKey(rnHomePage);
            return FastJsonUtil.success();
        } catch (Exception e) {
            logger.error("failed to update home page time by id", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return FastJsonUtil.errorInternal();
        }
    }

    @Transactional
    @Override
    public JSONObject createItem(JSONObject jsonObject) {
        try {
            RnHomePage rnHomePage = JSON.toJavaObject(jsonObject, RnHomePage.class);
            int id = rnHomePageMapper.insert(rnHomePage);
            JSONObject r = new JSONObject();
            r.put("id", id);
            return FastJsonUtil.success(r);
        } catch (Exception e) {
            logger.error("failed to insert home page item", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return FastJsonUtil.errorInternal();
        }
    }

    @Override
    @Transactional
    public JSONObject changePosition(JSONArray jsonArray) {
        try {
            JSONArray result = new JSONArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                RnHomePage rnHomePage = JSON.toJavaObject(jsonObject, RnHomePage.class);
                int r = rnHomePageMapper.updateByPrimaryKeySelective(rnHomePage);
                if (r == 0) {
                    result.add(rnHomePage.getId());
                }
            }
            return FastJsonUtil.success(result);
        } catch (Exception e) {
            logger.error("failed to change home page item order", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return FastJsonUtil.errorInternal();
        }
    }
}
