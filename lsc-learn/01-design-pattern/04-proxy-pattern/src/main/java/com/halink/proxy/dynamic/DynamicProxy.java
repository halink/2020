package com.halink.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> aClass = target.getClass();
        // 获取代理实例, 类加载器, 有哪些接口, 用那那个代理类
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);
    }

    /**
     * @param proxy  代理实例
     * @param method 调用那个方法
     * @param args   参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        //那个实例要调用这个方法，参数有哪些
        Object invoke = method.invoke(this.target, args);
        after();
        return invoke;
    }

    private void before() {
        System.out.println("前置通知");
    }

    private void after() {
        System.out.println("后置通知");
    }

}
