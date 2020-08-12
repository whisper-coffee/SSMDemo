package com.ssm.jdbc.test;

import com.ssm.jdbc.Dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTransactionTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/ssm/jdbc/config/applicationContextAnnotation.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        userDao.transfer("zhangsan","lisi",500);
    }
}
