package com.ssm.aspectj.test;

import com.ssm.aspectj.Dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class  xmlAspectTest {
    public static void main(String[] args) {
        String xmlPath = "com/ssm/aspectj/config/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        userDao.addUser();
    }
}
