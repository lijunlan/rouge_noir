package com.sdll18.rougenoir.be.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Copyright (C) 2015 - 2017 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: lijunlan888@gmail.com
 * @Date: 2017-01-10
 */
public interface RnUserService {

    JSONObject findUserById(Integer id);

    JSONObject login(JSONObject jsonObject);

    JSONObject register(JSONObject jsonObject);

    JSONObject updateInfo(JSONObject jsonObject);
}
