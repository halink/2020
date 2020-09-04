package com.halink.decorator;

public class DecoratorHome implements IHome {
    private Home home;

    public DecoratorHome(Home home) {
        this.home = home;
    }


    @Override
    public Integer getArea() {
        return this.home.getArea() - 10;
    }

    @Override
    public Integer getAestheticMeasure() {
        return this.home.getAestheticMeasure() + 20;
    }
}
