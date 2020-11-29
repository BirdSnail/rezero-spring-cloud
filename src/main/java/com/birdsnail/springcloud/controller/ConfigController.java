package com.birdsnail.springcloud.controller;

import com.birdsnail.springcloud.feign.RemoteHelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取配置信息的controller
 *
 * @Author : BirdSnail
 * @Date : 2020/11/6
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    private RemoteHelloService helloService;

    @Autowired
    public ConfigController(RemoteHelloService helloService) {
        this.helloService = helloService;
    }

    @Value("${ribbon.ReadTimeout}")
    private String readTimeout;

    @GetMapping("/get")
    public String get() {
        return readTimeout;
    }

    @GetMapping("/list")
    public String list() {
        return helloService.list();
    }

}
