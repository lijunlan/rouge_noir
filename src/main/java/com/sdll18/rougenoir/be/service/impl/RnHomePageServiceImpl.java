package com.sdll18.rougenoir.be.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sdll18.rougenoir.be.constant.Code;
import com.sdll18.rougenoir.be.mapper.RnHomePageMapper;
import com.sdll18.rougenoir.be.model.RnHomePage;
import com.sdll18.rougenoir.be.service.RnHomePageService;
import com.sdll18.rougenoir.be.util.FastJsonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (C) 2015 - 2017 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
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
            return FastJsonUtil.error(Code.ERROR_INTERNAL);
        }
    }

    @Override
    public JSONObject findItem(Integer id) {
        return null;
    }

    @Override
    public JSONObject updateItem(JSONObject jsonObject) {
        return null;
    }

    @Override
    public JSONObject createItem(JSONObject jsonObject) {
        return null;
    }

    @Override
    public JSONObject changePosition(JSONArray jsonArray) {
        return null;
    }
}
