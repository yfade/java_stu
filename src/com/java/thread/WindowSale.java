package com.java.thread;

/**
 * Created by pc on 2018/9/4.
 */

class Windows extends Thread{
    private static int ticket=100;
    private static Object obj=new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj){
                if (ticket>0){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"售票："+ticket--);
                }
                else
                    break;
            }
        }
    }
}
public class WindowSale {
    public static void main(String[] args) {
        Windows w1=new Windows();
        Windows w2=new Windows();
        Windows w3=new Windows();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }

}
