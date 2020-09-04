package com.halink.observer;


import java.util.Observable;

/**
 * 被观察者
 */
public class Lol extends Observable {

    private static Lol lol = null;
    private String name = "英雄联盟";

    private Lol() {
    }

    public static Lol getInstance() {
        if (null == lol) {
            lol = new Lol();
        }
        return lol;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Summoner summoner) {
        System.out.println(summoner.getUserName() + "在" + this.name + "上有新行动。");
        setChanged();
        notifyObservers(summoner);
    }
}
