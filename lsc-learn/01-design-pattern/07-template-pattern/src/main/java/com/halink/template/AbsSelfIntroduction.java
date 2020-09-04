package com.halink.template;

/**
 * 自我介绍的模板与话术顺序
 */
public abstract class AbsSelfIntroduction {

    protected final void introduction() {
        introductionName();
        introductionHometown();
        introductionHobby();
        introductionOver();
    }

    abstract void introductionName();

    abstract void introductionHometown();

    abstract void introductionHobby();

    abstract void introductionOver();

}
