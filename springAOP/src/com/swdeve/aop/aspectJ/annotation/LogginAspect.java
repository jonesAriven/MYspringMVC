package com.swdeve.aop.aspectJ.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogginAspect {

//    @AfterThrowing("execution(public int com.swdeve.aop.aspectJ.annotation.ArithmeticCalculatorImpl.sum(int,int))")
//    @Around("execution(public int com.swdeve.aop.aspectJ.annotation.ArithmeticCalculatorImpl.sum(int,int))")
//    @AfterReturning("execution(public int com.swdeve.aop.aspectJ.annotation.ArithmeticCalculatorImpl.sum(int,int))")
    @Before("execution(public int com.swdeve.aop.aspectJ.annotation.ArithmeticCalculatorImpl.sum(int,int))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println(methodName + "方法调用前的入参为：" + Arrays.asList(args));
    }
}
