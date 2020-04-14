package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.atguigu.springcloud.mapper")
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class PaymenMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymenMain8001.class,args);
    }
}
