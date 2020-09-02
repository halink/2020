package com.halink.singleton.enumr;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EnumSingletonTest {
    @Test
    public void test() {
        EnumSingleton instance = EnumSingleton.getInstance();
        EnumSingleton instance1;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream("Singleton.ocr");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(instance);
            objectOutputStream.flush();
            objectOutputStream.close();
            FileInputStream fileInputStream = new FileInputStream("Singleton.ocr");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            instance1 = (EnumSingleton) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(instance == instance1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
