package com.java.reflect;

import org.junit.Test;

/**
 * Created by pc on 2018/8/28.
 */
interface School {
    void doThing();
}

class Ludong implements School {
    @Override
    public void doThing() {
        System.out.println("i am ludong");
    }
}

class JingTai implements School {
    School school;

    public JingTai(School school) {
        this.school = school;
    }

    @Override
    public void doThing() {
        System.out.println("i am school");
        school.doThing();
    }
}

public class JingTaiDaiLi {
    @Test
    public void test() {
        Ludong ludong = new Ludong();
        JingTai jingTai = new JingTai(ludong);
        jingTai.doThing();
    }
}
