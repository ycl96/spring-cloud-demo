package com.ycl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author : YangChunLong
 * @date : Created in 2020/1/13 17:51
 * @description: eureka 启动类
 * @modified By:
 * @version: :
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class,args);
        System.out.println("Eureka 服务启动成功，端口：8002 .");
    }
}