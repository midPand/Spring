package com.bdqn.Spring.service.impl;

import com.bdqn.Spring.dao.UserMapper;
import com.bdqn.Spring.dao.impl.UserMapperImpl;
import com.bdqn.Spring.factory.BeanFactory;
import com.bdqn.Spring.service.UserService;

/**
 * 业务层实现类
 */
public class UserServiceImpl implements UserService {
   // private UserMapper userMapper=new UserMapperImpl ();
   UserMapper userMapper=(UserMapper)BeanFactory.getBean ("userMapper");  //解耦方式

    @Override
    public void AddUser() {
        userMapper.AddUser ();
    }
}
