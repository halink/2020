package com.halink.proxy.staticproxy;

public class StaticProxy {
    private MyLog myLog;

    public StaticProxy(MyLog myLog) {
        this.myLog = myLog;
    }

    public void message() {
        System.out.println("打印之日志前");
        this.myLog.message();
        System.out.println("打印之日志后");
    }


}
