package com.java.thread;

/**
 * Created by pc on 2018/9/3.
 */
public class TestThread extends Thread {
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            /*try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

class Test{
    public static void main(String[] args) throws InterruptedException {
        TestThread testThread=new TestThread();
        testThread.setName("子线程");
        testThread.setPriority(Thread.MAX_PRIORITY);
        testThread.start();
        Thread.currentThread().setName("主线程======");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i=0;i<100;i++){
            /*if (i==20)
//                Thread.currentThread().yield();
                testThread.join();*/
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        System.out.println(testThread.isAlive());
    }
}
