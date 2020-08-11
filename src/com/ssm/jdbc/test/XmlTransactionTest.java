package com.ssm.jdbc.test;

import com.ssm.jdbc.Dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlTransactionTest {
    public static void main(String[] args) {
        XmlTransactionTest xmlTransactionTest = new XmlTransactionTest();
        xmlTransactionTest.xmlTest();
    }

    public void xmlTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/ssm/jdbc/config/applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        userDao.transfer("zhangsan","lisi",500);
        System.out.println("赠送积分成功");
    }
}
