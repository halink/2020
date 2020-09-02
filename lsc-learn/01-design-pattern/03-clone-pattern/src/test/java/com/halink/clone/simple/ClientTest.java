package com.halink.clone.simple;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ClientTest {

    @Test
    public void test() {
        PrototypeA prototypeA = new PrototypeA();
        prototypeA.setName("name");
        prototypeA.setAge(23);
        prototypeA.setList(new ArrayList<String>());
        System.out.println(prototypeA);
        Client client = new Client(prototypeA);
        PrototypeA prototype = client.startClone();
        System.out.println(prototype);

        System.out.println(prototypeA.getList());
        System.out.println(prototype.getList());
        System.out.println(prototype.getList() == prototypeA.getList());
    }
}