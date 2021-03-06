package com.sdll18.rougenoir.be.controller;

import com.alibaba.fastjson.JSONObject;
import com.sdll18.rougenoir.be.util.FastJsonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C) 2015 - 2017 JUNLAN LI All Rights Reserved.
 *
 * @Author: lijunlan888@gmail.com
 * @Date: 2017-01-08
 */
@RestController
public class HealthController {

    @RequestMapping(value = "/health", produces = "application/json;charset=UTF-8")
    public JSONObject health() {
        return FastJsonUtil.success();
    }
}
