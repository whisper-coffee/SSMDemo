package com.ssm.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * �����࣬�ڴ����б�д֪ͨ
 * */
@Aspect
@Component
public class MyAnnotationAspectJ {

    //�����������ʽ
    @Pointcut("execution(* com.ssm.aspectj.Dao.*.*(..))")
    //ʹ��һ������ֵΪ void��������Ϊ�յķ��������������
    public void myPointCut(){}

    //ǰ��֪ͨ
    @Before("myPointCut()")
    public void myBefore(JoinPoint joinPoint){
        System.out.print("ǰ��֪ͨ��ģ��ִ��Ȩ�޼��...��");
        System.out.print("Ŀ������" + joinPoint.getTarget());
        System.out.println("����ֲ����ǿ�����Ŀ�귽��Ϊ��" + joinPoint.getSignature().getName());
    }


    //����֪ͨ
    @Around("myPointCut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("���ƿ�ʼ��ִ��Ŀ�귽��֮ǰ��ģ�⿪������...");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("���ƽ�����ִ��Ŀ�귽��֮��ģ��ر�����...");
        return obj;
    }

    //����֪ͨ
    @After("myPointCut()")
    public void myAfter(){
        System.out.println("����֪ͨ��ģ�ⷽ���������ͷ���Դ...");
    }

    //����֪ͨ
    @AfterReturning(value = "myPointCut()")
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.print("����֪ͨ��ģ���¼��־...��");
        System.out.println("��ֲ����ǿ�����Ŀ�귽��Ϊ��" + joinPoint.getSignature().getName());
    }

    //�쳣֪ͨ
    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
        System.out.println("�쳣֪ͨ��������"+e.getMessage());
    }
}
