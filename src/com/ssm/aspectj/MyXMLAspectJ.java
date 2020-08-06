package com.ssm.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类，在此类中编写通知
 * */
public class MyXMLAspectJ {

    //前置通知
    public void myBefore(JoinPoint joinPoint){
        System.out.print("前置通知：模拟执行权限检查...，");
        System.out.print("目标类是" + joinPoint.getTarget());
        System.out.println("，被植入增强处理的目标方法为：" + joinPoint.getSignature().getName());
    }

    //后置通知
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.print("后置通知：模拟记录日志...，");
        System.out.println("被植入增强处理的目标方法为：" + joinPoint.getSignature().getName());
    }

    /**
     * 环绕通知
     * ProceedingJoinPoint 是 JoinPoint 的子接口，表示可执行目标方法
     * 1.必须是 Object 类型的返回值
     * 2.必须接收一个参数，类型为 ProceedingJoinPoint
     * 3.必须是 throws Throwable
     */
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕开始：执行目标方法之前，模拟开启事务...");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("环绕结束：执行目标方法之后，模拟关闭事务...");
        return obj;
    }

    public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
        System.out.println("异常通知：出错了"+e.getMessage());
    }

    public void myAfter(){
        System.out.println("最终通知：模拟方法结束后释放资源...");
    }
}
