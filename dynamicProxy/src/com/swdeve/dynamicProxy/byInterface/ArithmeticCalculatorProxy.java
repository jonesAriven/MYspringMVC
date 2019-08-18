package com.swdeve.dynamicProxy.byInterface;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 基于接口实现动态代理
 * jdk动态代理：目标对象，代理对象，代理对象要做什么
 */
public class ArithmeticCalculatorProxy {
    //1.定义目标对象
    private Object target;


    public ArithmeticCalculatorProxy(Object target) {

        this.target = target;
    }

    //2.获取代理对象方法
    public Object getProxy() {
        //代理对象
        Object proxy;
        //获取类加载器
        ClassLoader loader = target.getClass().getClassLoader();
        //接口们
        Class[] interfaces = target.getClass().getInterfaces();
        System.out.println("interfaces为" + Arrays.asList(interfaces));

        /**
         * loader:类加载器
         * interface：接口们，提供目标对象的所有接口，目的是让目标对象保持与代理对象有相同的方法
         * InvocationHandler：代理对象调用的对象
         */
        proxy = Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
            /**
             * invoke 方法在Proxy.newProxyInstance执行时并不会执行，既代理对象创建时并不会执行
             *
             * @param proxy 代理对象
             * @param method 代理对象调用的目标对象的方法
             * @param args 代理对象调用目标对象的方法的参数
             * @return 代理对象调用目标对象方法的返回值
             * @throws Throwable 异常对象
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //在调用目标对象的目标方法之前
                System.out.println("开始调用" + target.getClass().getName() + "~" + method.getName() + ":" + Arrays.asList(args));
                // 3.代理对象要做什么 正式调用目标对象的目标方法，将调用代理烦方法转换到掉用目标对象的方法上去
                Object result = method.invoke(target,args);
                //在调用目标对象的目标方法之后
                System.out.println("结束调用" + target.getClass().getName() + "~" + method.getName() + "返回值为:" + result);
                return result;
            }
        });
        return proxy;

    }
}
