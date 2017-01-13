package com.sdll18.rougenoir.be.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sdll18.rougenoir.be.mapper.RnAddressMapper;
import com.sdll18.rougenoir.be.service.RnAddressService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (C) 2015 - 2017 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: lijunlan888@gmail.com
 * @Date: 2017-01-13
 */
@Service
public class RnAddressServiceImpl implements RnAddressService{

    private static final Logger logger = Logger.getLogger(RnAddressServiceImpl.class);

    @Autowired
    private RnAddressMapper rnAddressMapper;


    @Override
    public JSONObject createAddress(JSONObject jsonObject) {
        return null;
    }

    @Override
    public JSONObject updateAddress(JSONObject jsonObject) {
        return null;
    }

    @Override
    public JSONObject listAddress(JSONObject jsonObject) {
        return null;
    }

    @Override
    public JSONObject deleteAddress(Integer id) {
        return null;
    }
}
