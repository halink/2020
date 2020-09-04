package com.halink.template;


import org.junit.jupiter.api.Test;

class StudentBIntroductionTest {

    @Test
    public void test() {
        AbsSelfIntroduction absSelfIntroductionA = new StudentAIntroduction();
        AbsSelfIntroduction absSelfIntroductionB = new StudentBIntroduction();
        absSelfIntroductionA.introduction();
        absSelfIntroductionB.introduction();
    }
}