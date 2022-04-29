package com.example.sc.feign.common.rpc.service;

import org.springframework.stereotype.Component;

/**
 * 熔断回退处理类
 */
@Component
public class MHYFallbackDemo implements MHYFeignServiceDemo {
    @Override
    public String hiMhy(int flag) {
        return "mhy! 这里是Fallback。";
    }
}
