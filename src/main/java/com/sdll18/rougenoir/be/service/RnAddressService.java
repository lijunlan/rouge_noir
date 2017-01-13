package com.sdll18.rougenoir.be.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Copyright (C) 2015 - 2017 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: lijunlan888@gmail.com
 * @Date: 2017-01-10
 */
public interface RnAddressService {

    JSONObject createAddress(JSONObject jsonObject);

    JSONObject updateAddress(JSONObject jsonObject);

    JSONObject listAddress(JSONObject jsonObject);

    JSONObject deleteAddress(Integer id);

}
