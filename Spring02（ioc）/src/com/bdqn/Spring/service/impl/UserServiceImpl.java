package com.bdqn.Spring.service.impl;

import com.bdqn.Spring.dao.UserMapper;
import com.bdqn.Spring.dao.impl.UserMapperImpl;
import com.bdqn.Spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 业务层实现类
 */
public class UserServiceImpl implements UserService {
    private UserMapper userMapper=new UserMapperImpl ();

    @Override
    public void AddUser() {
        userMapper.AddUser ();
    }
}
