package com.halink.singleton.lazy;

/**
 * 懒汉
 *
 * @author halink
 * @date 2020/9/2 2:22 下午
 */
public class LazySingleton {
    private static LazySingleton LAZY_SINGLETON;

    // 防反射
    private LazySingleton() {
        if (null != LAZY_SINGLETON) {
            throw new RuntimeException("异常操作");
        }
    }

    // 线程不安全
    public static LazySingleton getInstance() {
        if (null == LAZY_SINGLETON) {
            LAZY_SINGLETON = new LazySingleton();
        }
        return LAZY_SINGLETON;
    }

    // 线程安全 双重检查锁
    public static LazySingleton getDoubleInstance() {
        if (null == LAZY_SINGLETON) {
            synchronized (LazySingleton.class) {
                if ((null == LAZY_SINGLETON)) {
                    LAZY_SINGLETON = new LazySingleton();
                }
            }
        }
        return LAZY_SINGLETON;
    }
}