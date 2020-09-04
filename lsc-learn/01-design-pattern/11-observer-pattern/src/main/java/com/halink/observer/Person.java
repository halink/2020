package com.halink.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 */
public class Person implements Observer {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Lol lol = (Lol) o;
        Summoner summoner = (Summoner) arg;
        System.out.println(name + "你好！你的" + lol.getName() + "的角色" + summoner.getUserName() + "有新行动：" + summoner.getMessage());
    }
}
