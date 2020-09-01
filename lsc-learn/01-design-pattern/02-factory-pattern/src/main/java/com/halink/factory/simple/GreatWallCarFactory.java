package com.halink.factory.simple;

public class GreatWallCarFactory implements ICarFactory {
    @Override
    public ICar create() {
        return new Haval();
    }
}
