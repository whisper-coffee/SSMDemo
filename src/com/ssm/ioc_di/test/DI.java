package com.ssm.ioc_di.test;

import com.ssm.ioc_di.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DI {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WebContent/resources/applicationContextIoCAndDI.xml");
        //getBean(String id)����ͨ��applicationContext.xml�����ļ��е�id����ȡֵ
        UserService userService = (UserService) applicationContext.getBean("UserService");
        userService.login();
    }
}
