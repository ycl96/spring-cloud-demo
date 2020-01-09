package com.ycl.service;

import com.ycl.dao.UserDao;
import com.ycl.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : YangChunLong
 * @date : Created in 2020/1/9 22:41
 * @description: 用户相关基础业务类
 * @modified By:
 * @version: :
 */
@Service
public class BaseUserService {
    @Autowired
    private UserDao userDao;

    public User findById(Long id) {
        return userDao.findById(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }
}
