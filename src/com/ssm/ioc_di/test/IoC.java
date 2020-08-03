package com.ssm.ioc_di.test;

import com.ssm.ioc_di.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoC {
    public static void main(String[] args){
        //1����ʼ��Spring���������������ļ�
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2��ͨ��������ȡUserDaoʵ��
        UserDao userDao = (UserDao)applicationContext.getBean("UserDao");
        //3������ʵ���е�login()����
        userDao.login();
    }
}
