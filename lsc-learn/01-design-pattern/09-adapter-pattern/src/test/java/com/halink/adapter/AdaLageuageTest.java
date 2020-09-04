package com.halink.adapter;

import org.junit.jupiter.api.Test;

class AdaLageuageTest {

    @Test
    public void test() {
        Chinese chinese = new Chinese();
        new AdaLageuage(chinese).sayEnglish("噫吁嚱");
    }

}