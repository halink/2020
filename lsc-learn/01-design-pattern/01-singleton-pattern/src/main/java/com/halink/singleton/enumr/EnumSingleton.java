package com.halink.singleton.enumr;

/**
 * 这个最奇妙，属于饿汉
 * 不受序列化的影响
 *
 *
 * @author LiKeshuang
 * @date 2020/9/2 3:14 下午
 */
public enum EnumSingleton {
    INSTANCE;
    private Object data;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
