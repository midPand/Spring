package com.bdqn.Spring.test;

import com.bdqn.Spring.factory.BeanFactory;
import com.bdqn.Spring.service.UserService;
import com.bdqn.Spring.service.impl.UserServiceImpl;
import org.junit.Test;

public class TestUser {
    @Test
    public void AddUser(){
        //UserService userService=new UserServiceImpl ();

        UserService userService=(UserService) BeanFactory.getBean("userService"); //解耦
        userService.AddUser ();
    }

}
