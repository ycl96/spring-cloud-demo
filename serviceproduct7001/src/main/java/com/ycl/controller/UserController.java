package com.ycl.controller;

import com.ycl.entites.User;
import com.ycl.service.BaseUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : YangChunLong
 * @date : Created in 2020/1/9 22:42
 * @description: 用户相关接口
 * @modified By:
 * @version: :
 */
@Controller
@RequestMapping("/product")
public class UserController {
    @Autowired
    private BaseUserService baseUserService;

    @RequestMapping(value = "/user/all",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser(){
        List<User> list = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setUserName("Lucy-"+i+1);
            user.setDbSource("cloudDb01");
            user.setEmail("email"+i+1);
            user.setId(i);
            user.setPhone("1234567890");
            user.setPwd("mima");
            list.add(user);
        }
//        list = baseUserService.findAll();
        return list;
    }

    @RequestMapping(value = "/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Long id){
        User user = new User();
        user.setUserName("Lucy-"+id+1);
        user.setDbSource("cloudDb01");
        user.setEmail("email"+id+1);
        user.setId(id.intValue());
        user.setPhone("1234567890");
        user.setPwd("mima");
//        user = baseUserService.findById(id);
        return user;
    }
}
