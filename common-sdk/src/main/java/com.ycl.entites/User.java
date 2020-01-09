package com.ycl.entites;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : YangChunLong
 * @date : Created in 2020/1/9 22:31
 * @description: 用户类
 * @modified By:
 * @version: :
 */
@Data
public class User implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 部门名称
     */
    private String userName;
    /**
     * 存储数据库位置（分布式部署可能存在多个数据库）
     */
    private String dbSource;
    /**
     * 电话号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String pwd;
}
