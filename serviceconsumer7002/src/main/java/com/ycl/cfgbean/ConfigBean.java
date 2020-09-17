package com.ycl.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author : YangChunLong
 * @date : Created in 2020/1/9 23:29
 * @description: 自定义 的 bean
 * @modified By:
 * @version: :
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ProtobufHttpMessageConverter protobufHttpMessageConverter(){
        return new ProtobufHttpMessageConverter();
    }
}
