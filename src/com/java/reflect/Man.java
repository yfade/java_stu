package com.java.reflect;

import java.math.BigDecimal;

/**
 * Created by pc on 2018/8/26.
 */
public class Man extends Person <String>{
    public String sex;
    private BigDecimal salary;

    @Override
    public void say(){
        System.out.println("sssss");
    }

    public String studay(String subject){
        System.out.println("study java");
        return subject;
    }

    @Override
    public String toString() {
        return "Man{" +
                "sex='" + sex + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
