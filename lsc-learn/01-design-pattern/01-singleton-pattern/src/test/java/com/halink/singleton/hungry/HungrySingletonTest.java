package com.halink.singleton.hungry;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class HungrySingletonTest {

    @Test
    void getInstance() {
        // 序列化
        FileOutputStream fos = null;
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance2;
        try {
            fos = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
            oos.flush();
            oos.close();
            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            instance2 = (HungrySingleton) ois.readObject();
            ois.close();
            System.out.println(instance);
            System.out.println(instance2);
            System.out.println(instance == instance2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}