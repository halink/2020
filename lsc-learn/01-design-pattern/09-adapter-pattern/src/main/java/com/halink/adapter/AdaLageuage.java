package com.halink.adapter;

public class AdaLageuage implements English {
    private Chinese chinese;

    public AdaLageuage(Chinese chinese) {
        this.chinese = chinese;
    }

    @Override
    public void sayEnglish(String content) {
        this.chinese.sayChinese("噫吁嚱");
        System.out.println("give me five");
    }
}
