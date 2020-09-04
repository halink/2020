package com.halink.strategy;

public enum WeatherEnum {
    /**
     * 天热
     */
    HOT_DAY("天比较热"),
    /**
     * 天冷
     */
    COLD_WEATHER("天比较冷"),
    /**
     * 默认
     */
    DEFAULT("不知道穿啥");

    private String desc;

    WeatherEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
