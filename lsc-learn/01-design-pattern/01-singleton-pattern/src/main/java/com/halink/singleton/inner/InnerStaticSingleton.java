package com.halink.singleton.inner;

/**
 * 静态内部类
 *
 * @author halink
 * @date 2020/9/2 2:22 下午
 */
public class InnerStaticSingleton {

    private InnerStaticSingleton() {
        System.out.println("构造函数");
    }

    public static InnerStaticSingleton getInstance() {
        return InnerClass.INNER_STATIC_SINGLETION;
    }

    private static class InnerClass {
        private static final InnerStaticSingleton INNER_STATIC_SINGLETION = new InnerStaticSingleton();
    }
}
