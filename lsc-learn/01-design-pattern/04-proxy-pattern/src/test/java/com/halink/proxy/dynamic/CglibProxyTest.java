package com.halink.proxy.dynamic;

import org.junit.jupiter.api.Test;

class CglibProxyTest {
    @Test
    public void test() {
        MyCar instance = (MyCar) new CglibProxy().getInstance(MyCar.class);
        instance.run();
    }
}