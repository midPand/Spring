·package com.bdqn.Spring.dao.impl;

import com.bdqn.Spring.dao.UserMapper;

/**
 * 用户持久层实现类
 */
public class UserMapperImpl implements UserMapper{
    @Override
    public void AddUser() {
        System.out.println("保存成功");
    }
}
