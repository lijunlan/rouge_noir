package com.sdll18.rougenoir.be.mvc.interceptor;

import com.sdll18.rougenoir.be.util.RemoteIPUtil;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-11-08
 */
public class LogInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = Logger.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = RemoteIPUtil.getAddr(request);
        logger.info(String.format("Request message from IP: %s ; URL is: %s ; Method is: %s ; Length is: %s",
                ip,
                request.getRequestURL().toString(),
                request.getMethod(),
                request.getContentLength()));
        return true;
    }

}
