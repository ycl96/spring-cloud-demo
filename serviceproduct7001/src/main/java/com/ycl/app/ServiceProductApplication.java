package com.ycl.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author : YangChunLong
 * @date : Created in 2020/1/9 22:44
 * @description: 启动类
 * @modified By:
 * @version: :
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ycl")
@ComponentScan(value = "com.ycl")
public class ServiceProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProductApplication.class, args);
        System.out.println("业务生产者服务启动成功，端口：7001 .");
    }
}
