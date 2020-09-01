package com.halink.factory.abs;

public class AbsTest {
    public static void main(String[] args) {
        IFactory factory = new BydFactory();
        factory.createCar().didi();
        factory.createPhone().desc();
    }
}
