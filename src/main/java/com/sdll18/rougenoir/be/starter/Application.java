package com.sdll18.rougenoir.be.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-12-06
 */
@SpringBootApplication(scanBasePackages = "com.sdll18.rougenoir.be")
@ServletComponentScan(basePackages = "com.sdll18.rougenoir.be")
@MapperScan(basePackages = "com.sdll18.rougenoir.be")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
