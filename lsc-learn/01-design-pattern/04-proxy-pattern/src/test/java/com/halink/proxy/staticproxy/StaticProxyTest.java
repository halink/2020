package com.halink.proxy.staticproxy;


import org.junit.jupiter.api.Test;

class StaticProxyTest {
    @Test
    public void test() {
        MyLog myLog = new MyLog();
        new StaticProxy(myLog).message();
    }
}