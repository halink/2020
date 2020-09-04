package com.halink.decorator;


import org.junit.jupiter.api.Test;

class DecoratorHomeTest {

    @Test
    public void test() {
        Home home = new Home();
        home.setArea(120);
        home.setAestheticMeasure(20);
        System.out.println("原面积：" + home.getArea());
        System.out.println("原观赏度：" + home.getAestheticMeasure());
        DecoratorHome decoratorHome = new DecoratorHome(home);
        System.out.println("装饰后面积：" + decoratorHome.getArea());
        System.out.println("装饰后观赏度：" + decoratorHome.getAestheticMeasure());
    }
}