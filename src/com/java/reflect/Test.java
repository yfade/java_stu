package com.java.reflect;

/**
 * Created by pc on 2018/9/19.
 */
public class Test {
    private String name;

    public Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class KK{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class clzz=Test.class;
        Test t =(Test)clzz.newInstance();
        System.out.println(t);
    }
}
