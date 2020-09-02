package com.halink.proxy.staticproxy;

public class MyLog implements Log {

    @Override
    public void message() {
        System.out.println("这是打印日志");
    }
}
