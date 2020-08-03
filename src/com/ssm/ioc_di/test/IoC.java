package com.ssm.ioc_di.test;

import com.ssm.ioc_di.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoC {
    public static void main(String[] args){
        //1、初始化Spring容器，加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2、通过容器获取UserDao实例
        UserDao userDao = (UserDao)applicationContext.getBean("UserDao");
        //3、调用实例中的login()方法
        userDao.login();
    }
}
