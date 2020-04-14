package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.atguigu.springcloud.mapper")
@SpringBootApplication
@EnableEurekaClient
public class PaymenMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymenMain8002.class,args);
    }
}