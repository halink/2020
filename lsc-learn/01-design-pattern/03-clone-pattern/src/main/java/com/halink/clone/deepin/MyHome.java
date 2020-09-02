package com.halink.clone.deepin;

import java.io.*;

public class MyHome implements Cloneable, Serializable {
    private String name;
    private Car car;

    public MyHome() {
        this.car = new Car();
        this.name = "halink Home";
    }


    @Override
    protected Object clone() {
        return this.deepClone();
    }

    public Object deepClone() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            MyHome o = (MyHome) objectInputStream.readObject();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
