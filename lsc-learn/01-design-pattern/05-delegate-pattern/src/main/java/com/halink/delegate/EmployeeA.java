package com.halink.delegate;

public class EmployeeA implements IEmployee {
    @Override
    public void doing(String task) {
        System.out.println("i`m A. my task is " + task);
    }
}
