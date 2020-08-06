package com.ssm.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * �����࣬�ڴ����б�д֪ͨ
 * */
public class MyXMLAspectJ {

    //ǰ��֪ͨ
    public void myBefore(JoinPoint joinPoint){
        System.out.print("ǰ��֪ͨ��ģ��ִ��Ȩ�޼��...��");
        System.out.print("Ŀ������" + joinPoint.getTarget());
        System.out.println("����ֲ����ǿ�����Ŀ�귽��Ϊ��" + joinPoint.getSignature().getName());
    }

    //����֪ͨ
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.print("����֪ͨ��ģ���¼��־...��");
        System.out.println("��ֲ����ǿ�����Ŀ�귽��Ϊ��" + joinPoint.getSignature().getName());
    }

    /**
     * ����֪ͨ
     * ProceedingJoinPoint �� JoinPoint ���ӽӿڣ���ʾ��ִ��Ŀ�귽��
     * 1.������ Object ���͵ķ���ֵ
     * 2.�������һ������������Ϊ ProceedingJoinPoint
     * 3.������ throws Throwable
     */
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("���ƿ�ʼ��ִ��Ŀ�귽��֮ǰ��ģ�⿪������...");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("���ƽ�����ִ��Ŀ�귽��֮��ģ��ر�����...");
        return obj;
    }

    public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
        System.out.println("�쳣֪ͨ��������"+e.getMessage());
    }

    public void myAfter(){
        System.out.println("����֪ͨ��ģ�ⷽ���������ͷ���Դ...");
    }
}
