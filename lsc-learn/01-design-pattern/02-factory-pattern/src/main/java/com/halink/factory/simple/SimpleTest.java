package com.halink.factory.simple;

public class SimpleTest {
    public static void main(String[] args) {
        ICarFactory iCarFactory = new GreatWallCarFactory();
        iCarFactory.create().desc();
    }
}
