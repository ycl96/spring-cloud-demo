package com.ycl.dao;

import com.ycl.entites.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    User findById(Long id);
}
