package com.halink.template;

public class StudentBIntroduction extends AbsSelfIntroduction {
    @Override
    void introductionName() {
        System.out.println("我叫狗蛋");
    }

    @Override
    void introductionHometown() {
        System.out.println("来自荒原");
    }

    @Override
    void introductionHobby() {
        System.out.println("爱好：放羊");
    }

    @Override
    void introductionOver() {
        System.out.println("欢迎大家到我的家乡");
    }
}
