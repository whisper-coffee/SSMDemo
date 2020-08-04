package com.ssm.bean.test;

import com.ssm.bean.Controller.AnnotationUserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/ssm/bean/bean1.xml");

        AnnotationUserController annotationUserController = (AnnotationUserController)applicationContext.getBean("annotationUserController");
        annotationUserController.save();
    }

}
