package com.ycl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author : YangChunLong
 * @date : Created in 2020/1/9 23:22
 * @description: 消费者服务 启动类
 * @modified By:
 * @version: :
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.ycl")
@EnableEurekaClient
public class ServiceConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication.class,args);
        System.out.println("业务消费者服务启动成功，端口：7002 .");
    }
}
