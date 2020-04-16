package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope  // 实现客户端动态刷新需要加的注解，http://localhost:3355/actuator/refresh
@RestController
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info.version}")
    private String configInfo;

    /*
        客户端是不会自动更新配置的，需要我们手动刷新
     */
    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo+"==="+serverPort;
    }
}