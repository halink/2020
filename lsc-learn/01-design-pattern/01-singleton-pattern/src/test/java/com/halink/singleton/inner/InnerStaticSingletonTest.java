package com.halink.singleton.inner;

import org.junit.jupiter.api.Test;

class InnerStaticSingletonTest {


    @Test
    public void test() {
        InnerStaticSingleton instance = InnerStaticSingleton.getInstance();
        InnerStaticSingleton instance1 = InnerStaticSingleton.getInstance();
        System.out.println(instance);
        System.out.println(instance1);
        System.out.println(instance == instance1);
    }
}
