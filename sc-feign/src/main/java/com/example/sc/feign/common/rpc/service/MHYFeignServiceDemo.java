package com.example.sc.feign.common.rpc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign服务演示
 * 通过@ FeignClient（"服务名"），来指定调用哪个服务。比如在代码中调用了eureka的client-mhy服务的“/hw”接口
 */
@FeignClient(value = "client-mhy", fallbackFactory = MHYFallbackFactoryDemo.class)
public interface MHYFeignServiceDemo {

    @RequestMapping(method = RequestMethod.GET, value = "/mhy")
    String hiMhy(@RequestParam(name = "flag", required = false) int flag);

}
