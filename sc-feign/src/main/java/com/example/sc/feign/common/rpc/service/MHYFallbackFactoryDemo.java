package com.example.sc.feign.common.rpc.service;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 熔断回退
 */
@Component
public class MHYFallbackFactoryDemo implements FallbackFactory<MHYFallbackDemo> {
    @Override
    public MHYFallbackDemo create(Throwable cause) {
        System.out.println("这里可以打印具体错误信息。");
        cause.printStackTrace();
        return new MHYFallbackDemo();
    }
}
