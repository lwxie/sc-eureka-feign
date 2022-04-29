package com.example.sc.app.web.controller;

import com.example.sc.feign.common.rpc.service.MHYFeignServiceDemo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示调用Feign接口
 */
@RestController
@RequiredArgsConstructor
public class MainController {
    private final MHYFeignServiceDemo mhyFeignServiceDemo;

    @RequestMapping(path = "/demo", method = RequestMethod.GET)
    public String sayHiFromClientOne(@RequestParam(name = "flag", required = false) int flag) {
        return mhyFeignServiceDemo.hiMhy(flag);
    }
}
