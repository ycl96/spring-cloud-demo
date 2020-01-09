package com.ycl.controller;

import com.ycl.entites.User;
import com.ycl.service.BaseUserService;
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
        return baseUserService.findAll();
    }

    @RequestMapping(value = "/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Long id){
        return baseUserService.findById(id);
    }
}
