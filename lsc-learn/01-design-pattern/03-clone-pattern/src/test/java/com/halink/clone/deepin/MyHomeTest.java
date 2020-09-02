package com.halink.clone.deepin;

import org.junit.jupiter.api.Test;

class MyHomeTest {

    @Test
    public void test() {
        MyHome myHome = new MyHome();
        System.out.println(myHome);
        MyHome clone = (MyHome) myHome.clone();
        System.out.println(clone);
        System.out.println(myHome == clone);
    }

}