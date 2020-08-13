package com.ssm.aspectj.test;

import com.ssm.aspectj.Dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class annotationAspectJTest {
    public static void main(String[] args) {
        String xmlPath = "com/ssm/config/applicationContextAopAnnotation.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //Ö´ÐÐË³Ðò£ºAround - Before - After - After-Returning
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        userDao.addUser();
    }
}
