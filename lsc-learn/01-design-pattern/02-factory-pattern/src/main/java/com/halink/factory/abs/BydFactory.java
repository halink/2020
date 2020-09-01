package com.halink.factory.abs;

public class BydFactory implements IFactory {
    @Override
    public ICar createCar() {
        return new BydCar();
    }

    @Override
    public IPhone createPhone() {
        return new BydPhone();
    }
}
