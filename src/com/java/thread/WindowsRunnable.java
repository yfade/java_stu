package com.java.thread;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * Created by pc on 2018/9/4.
 */

/**
 * 解决线程安全问题，使用线程的同步
 * 1、同步代码块
 *  synchronized(同步监视器){
 *      //需要被同步的代码块（即操作共享数据的代码）
 *  }
 *  共享数据：即多个线程共同操作的同一个数据（变量），这里即ticket
 *  同步监视器：由一个类（任何一个类都行）的对象充当，哪个线程获取到此监视器，谁就执行大括号里被同步的代码。俗称：锁。
 *  注：同步监视器对象必须是是多个线程共享的，
 *      当通过实现方式进行多线程时，对象不能是局部变量（可以是成员变量）即保证同步监视器被多线程共享，也可以使用this。
 *      当通过继承方式使用多线程时，对象是普通成员变量也不行。也不能使用this解决线程安全。可以在成员变量前加上static。
 * 2、同步方法：
 */
public class WindowsRunnable implements Runnable {
    private int ticket=100;
    @Override
    public void run() {
        while (true){
//            synchronized (this){
//            }
            show();
        }
    }
    public synchronized void show(){
        if (ticket>0) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"售票："+ticket--);
        }
    }
}
class TestClass{
    public static void main(String[] args) {
        WindowsRunnable r=new WindowsRunnable();
        Thread t1=new Thread(r);
        Thread t2=new Thread(r);
        Thread t3=new Thread(r);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}