package com.ssm.bean.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBeanUserTest {
    public static void main(String[] args) {
        //初始化 Spring 容器，加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println(applicationContext.getBean("user1"));
        System.out.println(applicationContext.getBean("user2"));
    }
}
