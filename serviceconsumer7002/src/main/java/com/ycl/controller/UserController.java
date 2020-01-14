package com.ycl.controller;

import com.ycl.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    private String getUrl_pre (){
        ServiceInstance productService = loadBalancerClient.choose("service-product-application");
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
        return restTemplate.getForEntity(url, User.class);
    }
}
