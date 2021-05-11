package com.ssm.ioc_di.test;

import com.ssm.ioc_di.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DI {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WebContent/resources/applicationContextIoCAndDI.xml");
        //getBean(String id)方法通过applicationContext.xml配置文件中的id进行取值
        UserService userService = (UserService) applicationContext.getBean("UserService");
        userService.login();
    }
}
