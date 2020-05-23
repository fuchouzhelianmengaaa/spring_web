package com.demo.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class MyInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long start=System.currentTimeMillis();
        Object reuslt=null;
        try {
            reuslt=methodInvocation.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            long end=System.currentTimeMillis();
            System.out.println("耗时："+(end-start)+"ms");
        }
        return reuslt;
    }
}
