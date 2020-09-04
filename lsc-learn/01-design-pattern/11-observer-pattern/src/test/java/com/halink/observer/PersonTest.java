package com.halink.observer;

import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    public void test() {
        Lol instance = Lol.getInstance();

        Person person1 = new Person("张三");
        Person person2 = new Person("李四");
        instance.addObserver(person1);
        instance.addObserver(person2);

        Summoner summoner = new Summoner();
        summoner.setMessage("有去蹲草丛了");
        summoner.setUserName("盖伦");

        instance.publishQuestion(summoner);
    }

}