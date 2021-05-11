package com.ssm.bean.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WebContent/resources/applicationContextIoCAndDI.xml");
        //单例（默认） 每次都是使用同一个实例
        System.out.println("singleton------------");
        System.out.println(applicationContext.getBean("scopeSingleton"));//com.ssm.bean.Scope@735b5592
        System.out.println(applicationContext.getBean("scopeSingleton"));//com.ssm.bean.Scope@735b5592
        //原型 每次都新生成一个实例
        System.out.println("prototype------------");
        System.out.println(applicationContext.getBean("scopePrototype"));//com.ssm.bean.Scope@58651fd0
        System.out.println(applicationContext.getBean("scopePrototype"));//com.ssm.bean.Scope@4520ebad
    }

}
