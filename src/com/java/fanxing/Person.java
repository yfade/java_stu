package com.java.fanxing;

/**
 * Created by pc on 2018/9/17.
 */
public class Person<T> {
    private String name;
    private T t;

    public <E> E testT(){
        Animal animal=new Animal();
        animal.setName("dog");
        return (E) animal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
class Test{
    public static void main(String[] args) {
        Person person=new Person();
        person.testT();
    }
}
