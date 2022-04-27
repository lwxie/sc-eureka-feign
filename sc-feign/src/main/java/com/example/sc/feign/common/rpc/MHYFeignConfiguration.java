package com.example.sc.feign.common.rpc;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.var;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
public class MHYFeignConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> requestTemplate.header("mhy","米忽悠");
    }
}
