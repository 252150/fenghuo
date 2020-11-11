package com.wanjia.infoshopmallmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@MapperScan(basePackages = "com.wanjia.infoshopmallmanage.mapper")
@SpringBootApplication
public class InfoShopMallManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfoShopMallManageApplication.class, args);
    }

}
