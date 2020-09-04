package com.halink.strategy;

import java.util.HashMap;
import java.util.Map;

public class DressingStrategy {

    private static final Map<WeatherEnum, Clothes> weatherEnumClothesMap;

    static {
        weatherEnumClothesMap = new HashMap<>();
        weatherEnumClothesMap.put(WeatherEnum.HOT_DAY, new ShortSleeve());
        weatherEnumClothesMap.put(WeatherEnum.COLD_WEATHER, new LongSleeve());
        weatherEnumClothesMap.put(WeatherEnum.DEFAULT, new ShortSleeve());
    }

    public static Clothes get(WeatherEnum weatherEnum) {
        System.out.println(weatherEnum.getDesc());
        return weatherEnumClothesMap.get(weatherEnum);
    }
}
