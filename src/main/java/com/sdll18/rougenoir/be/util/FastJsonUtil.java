package com.sdll18.rougenoir.be.util;

import com.alibaba.fastjson.JSONObject;
import com.sdll18.rougenoir.be.constant.Code;

public final class FastJsonUtil {

    public static JSONObject errorInternal() {
        return error(Code.ERROR_INTERNAL, "internal error");
    }


    public static JSONObject error(int code, String msg) {
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static JSONObject error(int code, String msg, Object data) {
        JSONObject result = error(code, msg);
        result.put("data", data);
        return result;
    }


    public static JSONObject success(String msg, Object data) {
        JSONObject result = success(msg);
        result.put("data", data);
        return result;
    }

    public static JSONObject success(Object data) {
        return success("success", data);
    }

    public static JSONObject success() {
        return success("success");
    }

    public static JSONObject success(String msg) {
        JSONObject result = new JSONObject();
        result.put("code", Code.SUCCESS);
        result.put("msg", msg);
        return result;
    }


}
