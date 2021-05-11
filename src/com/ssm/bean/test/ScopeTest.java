package com.ssm.bean.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WebContent/resources/applicationContextIoCAndDI.xml");
        //������Ĭ�ϣ� ÿ�ζ���ʹ��ͬһ��ʵ��
        System.out.println("singleton------------");
        System.out.println(applicationContext.getBean("scopeSingleton"));//com.ssm.bean.Scope@735b5592
        System.out.println(applicationContext.getBean("scopeSingleton"));//com.ssm.bean.Scope@735b5592
        //ԭ�� ÿ�ζ�������һ��ʵ��
        System.out.println("prototype------------");
        System.out.println(applicationContext.getBean("scopePrototype"));//com.ssm.bean.Scope@58651fd0
        System.out.println(applicationContext.getBean("scopePrototype"));//com.ssm.bean.Scope@4520ebad
    }

}
