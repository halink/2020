package com.halink.proxy.dynamic;

public class Me implements Person {
    @Override
    public void song() {
        System.out.println("想要给你的思念, 就像风筝断了线");
    }

    @Override
    public void see() {
        System.out.println("你猜我看到了什么，嘿嘿嘿");
    }
}
