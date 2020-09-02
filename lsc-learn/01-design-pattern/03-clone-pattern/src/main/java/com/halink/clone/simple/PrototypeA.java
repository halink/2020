package com.halink.clone.simple;

import java.util.List;

public class PrototypeA implements Prototype {
    private String name;
    private Integer age;
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public Prototype clone() {
        PrototypeA prototypeA = new PrototypeA();
        prototypeA.setAge(this.age);
        prototypeA.setName(this.name);
        prototypeA.setList(this.list);
        return prototypeA;
    }
}
