package com.zhishu.hd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableConfigurationProperties
@MapperScan(basePackages = "com.zhishu.hd.model.dao.mapper" )
public class HdApplication {

    public static void main(String[] args) {
        SpringApplication.run(HdApplication.class, args);
    }

}
