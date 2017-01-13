package com.sdll18.rougenoir.be.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Copyright (C) 2015 - 2017 JUNLAN LI All Rights Reserved.
 *
 * @Author: lijunlan888@gmail.com
 * @Date: 2017-01-10
 */
public interface RnHomePageService {

    JSONObject listItems();

    JSONObject findItem(Integer id);

    JSONObject updateItem(JSONObject jsonObject);

    JSONObject createItem(JSONObject jsonObject);

    JSONObject changePosition(JSONArray jsonArray);

}
