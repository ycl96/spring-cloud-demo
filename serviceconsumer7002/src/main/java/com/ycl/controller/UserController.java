package com.ycl.controller;

import com.ycl.entites.User;
import com.ycl.model.InputOutputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author : YangChunLong
 * @date : Created in 2020/1/9 23:10
 * @description: 消费者  用户相关业务类
 * @modified By:
 * @version: :
 */
@Controller
@RequestMapping(value = "/consumer")
public class UserController {
    /**
     * 服务提供方地址
     */
//    private static final String url = "http://localhost:7001/product/";

    /**
     * RestTemplate 提供了多种便捷访问远程HTTP服务的方法
     * 是一种简单便捷的访问restful服务模版类，是Spring提供的用于访问
     * Rest服务的客户端模版工具集
     */
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient; // ribbon 负载均衡器

    private static String SERVICE_NAME_PRODUCT = "service-product-application";

    /**
     * @author     : YangChunLong
     * @date       : Created in 2020/9/18 00:13
     * @description: 根据eureka 中注册的服务名，获取其主机名（域名），用于服务之间的调用（方法一）
     * 方法二： 通过初始化RestTemplate的实例对象时 加入注解：@LoadBalanced, 即可采用 restTemplate.getForObject("http://{service_name}:{port}/"的方式调用
     * @modified By:
     * @Param:
     * @return     : java.lang.String
     */
    private String getUrl_pre (){
        ServiceInstance productService = loadBalancerClient.choose(SERVICE_NAME_PRODUCT);
        String url_pre = "http://" + productService.getHost() + ":" + productService.getPort() + "/product";
        return url_pre;
    }


    @RequestMapping(value = "/user/all")
    @ResponseBody
    public List getUserAll() {
        String url = getUrl_pre() + "/user/all";
        return restTemplate.getForObject(url, List.class);
    }

    @RequestMapping(value = "/user/{id}")
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        String url = getUrl_pre() + "/user/" + id.toString();
        url = String.format("http://%s/user/"+id,SERVICE_NAME_PRODUCT);
        return restTemplate.getForEntity(url, User.class);
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public InputOutputData.Output test(){
        // 反序列化后
//        System.out.println(input.getName());
//        System.out.println(input.getAge());

        // 输出
        InputOutputData.Output.Builder outBuilder = InputOutputData.Output.newBuilder();
        outBuilder.setResult("老大回来了");

        return outBuilder.build();
    }

}
