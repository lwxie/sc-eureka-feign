package com.example.sc.feign.impl.client.web.controller;

import com.example.sc.common.ServiceException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 做为Feign客户端接口的实现
 */
@RestController
public class ClientControllerDemo {

    @RequestMapping(method = RequestMethod.GET, value = "/mhy")
    public String hiMhy(@RequestParam(name = "flag", required = false) int flag) {
        // 这里抛异常或者将Feign实现客户端关闭，即可实现熔断回退。
        if (flag == 1) {
            // 注：如做了全局异常处理，那么当Feign实现客户端服务还存活着 异常处理走全局异常处理，如Feign实现客户端已然停止服务 异常处理走熔断回退。
            throw new ServiceException("sc:error_demo", "错误演示。");
        }
        return "Hello mhy!!!";
    }
}
