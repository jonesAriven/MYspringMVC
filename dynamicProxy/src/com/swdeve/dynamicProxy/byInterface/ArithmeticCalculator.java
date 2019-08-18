package com.swdeve.dynamicProxy.byInterface;

/**
 * 创建动态代理代理目标的接口类
 */
public interface ArithmeticCalculator {

    int sum(int a, int b);

    int sub(int a, int b);

    int mul(int a, int b);

    int div(int a, int b);
}
