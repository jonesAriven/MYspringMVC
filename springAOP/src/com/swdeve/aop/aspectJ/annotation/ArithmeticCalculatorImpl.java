package com.swdeve.aop.aspectJ.annotation;

import org.springframework.stereotype.Component;

@Component
public class ArithmeticCalculatorImpl {

    public int sum(int a,int b){
        return a+b;
    }
}
