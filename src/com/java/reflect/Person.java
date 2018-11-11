package com.java.reflect;

/**
 * Created by pc on 2018/8/25.
 */
public class Person<String> {
    public String name;
    private int age;

    public Person() {
    }

    public Person(String name){
        this.name=name;
    }

    private void friends(String name1,String name2){
        System.out.println(name1+"----"+name2);
    }

    public void say(){
        System.out.println("i am nervous!");
    }

    public String eat(String food){
        System.out.println("eat "+food);
        return food;
    }

    @Override
    public java.lang.String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
