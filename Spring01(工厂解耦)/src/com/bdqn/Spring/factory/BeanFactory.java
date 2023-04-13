package com.bdqn.Spring.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
     
/**
 * 一个创建Bean对象的工厂
 *
 *  Bean：可重用组件
 *  javabean>实体类
 *
 * 1.需要一个配置文件配置service,dao  (xml,properties)
 *          配置的内容：唯一标识，全限定类名（key,value）
 *  2.通过读取配置文件中的配置内容，反射创建
 */
public class BeanFactory {
    //定制一个properties对象
    private static Properties props;
    //定义一个Map,用于存放创建的对象，“容器”
    private  static Map<String,Object> beans;
    //使用静态代码块为properties对象赋值
    static {
        try {
            //实例化对象
            props=new Properties ();
            //获取properties文件的流对象
            InputStream inputStream=BeanFactory.class.getClassLoader ().getResourceAsStream ("bean.properties");
            props.load (inputStream);
            //实例化容器
            beans=new HashMap<String,Object>();
            //取出配置文件中的所有key
            Enumeration keys=props.keys ();
            //遍历枚举
            while (keys.hasMoreElements ()){
                //取出每个key
                String key=keys.nextElement ().toString ();
                //根据key获取value
                String beanPath=props.getProperty (key);
                //反射创建对象
                Object value=Class.forName (beanPath).newInstance ();
                //把Key value存入容器
                beans.put (key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError ("初始化失败");
        }
    }

    public static Object getBean(String beanName){
        return beans.get (beanName);
    }

    /**
     * 根据bean名称获取bean对象
     * @param beanName
     * @return
     */
    /**
    public static Object getBean(String beanName){
        Object bean=null;
        try {
            String beanpath=props.getProperty (beanName);
            bean= Class.forName (beanpath).newInstance ();  //每次都会调用默认构造函数创建对象
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return bean;
    }**/
}
