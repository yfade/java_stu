package com.java.thread;

/**
 * Created by pc on 2018/9/10.
 */
public class ThreadTongxin implements Runnable{
    private int i=1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notify();
                if (i<=100){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+i);
                    i++;
                }else
                    break;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class TestClass1{
    public static void main(String[] args) {
        ThreadTongxin r=new ThreadTongxin();
        Thread t1=new Thread(r);
        Thread t2=new Thread(r);
        t1.setName("甲方");
        t2.setName("乙方");

        t1.start();
        t2.start();
    }
}
