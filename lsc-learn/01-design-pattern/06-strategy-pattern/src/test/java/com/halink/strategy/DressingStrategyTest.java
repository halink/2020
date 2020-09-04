package com.halink.strategy;


import org.junit.jupiter.api.Test;

class DressingStrategyTest {

    @Test
    public void test() {
        DressingStrategy.get(WeatherEnum.COLD_WEATHER).printName();
    }
}