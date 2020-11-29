package com.birdsnail.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author : BirdSnail
 * @Date : 2020/11/6
 */
@FeignClient(name = "ruoyi-system")
public interface RemoteHelloService {

    @GetMapping("/user/list")
    String list();

}
