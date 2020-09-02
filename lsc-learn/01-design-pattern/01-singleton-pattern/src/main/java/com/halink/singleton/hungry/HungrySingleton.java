package com.halink.singleton.hungry;

import java.io.Serializable;

/**
 * 饿汉
 *
 * @author halink
 * @date 2020/9/2 10:40 上午
 */
public class HungrySingleton implements Serializable {
    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return HUNGRY_SINGLETON;
    }

    /**
     * 防止序列化
     *
     * @return
     */
    private Object readResolve() {
        return HUNGRY_SINGLETON;
    }
}
