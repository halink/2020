package com.halink.proxy.dynamic;

import org.junit.jupiter.api.Test;

class DynamicProxyTest {
    @Test
    public void test() {
        Me me = new Me();
        System.out.println(me);
        Person person = (Person) new DynamicProxy().getInstance(me);
        // 这里调用了toString
        System.out.println(person);
        person.song();
        person.see();
    }


}