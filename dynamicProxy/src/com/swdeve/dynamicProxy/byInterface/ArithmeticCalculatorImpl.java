package com.swdeve.dynamicProxy.byInterface;

/**
 * 创建动态代理代理目标的实现类
 */
public class ArithmeticCalculatorImpl implements ArithmeticCalculator{


    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        return a-b;
    }

    @Override
    public int mul(int a, int b) {
        return a*b;
    }

    @Override
    public int div(int a, int b) {
        return a/b;
    }
}
