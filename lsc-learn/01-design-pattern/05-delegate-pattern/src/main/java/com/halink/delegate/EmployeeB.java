package com.halink.delegate;

public class EmployeeB implements IEmployee {
    @Override
    public void doing(String task) {
        System.out.println("i`m B. my task is " + task);
    }
}
