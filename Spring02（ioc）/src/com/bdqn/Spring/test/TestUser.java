package com.bdqn.Spring.test;



import com.bdqn.Spring.dao.UserMapper;
import com.bdqn.Spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestUser {
    /**
     * 获取spring IOC核心容器，并根据ID获取对象
     *
     * ClassPathXmlApplicationContext     可以加载类路径下的配置文件 要求配置文件必须在类路径下
     * FileSystemXmlApplicationContext   可以加载磁盘任意路径下的配置文件
     * AnnotationConfigApplicationContext   用于读取注解创建容器的
     */
    @Test
    public void AddUser(){
        //UserService userService=new UserServiceImpl ();
        //userService.AddUser ();

        //1.获取核心容器
        ApplicationContext ac=new ClassPathXmlApplicationContext ("bean.xml");
        //2.根据id获取Bean对象
        UserService userService=(UserService) ac.getBean ("userService");
        UserMapper userMapper=ac.getBean ("userMapper",UserMapper.class);
        System.out.println(userService);
        System.out.println(userMapper);
    }

}
