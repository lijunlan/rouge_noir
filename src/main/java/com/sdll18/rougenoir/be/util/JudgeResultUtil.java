package com.sdll18.rougenoir.be.util;

import com.alibaba.fastjson.JSONObject;
import com.sdll18.rougenoir.be.constant.Code;


/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: lijunlan888@gmail.com
 * @Date: 2016-12-08
 */
public final class JudgeResultUtil {

    public static boolean getResult(JSONObject jsonObject) {
        if (jsonObject.getIntValue("code") == Code.SUCCESS) return true;
        return false;
    }
}

