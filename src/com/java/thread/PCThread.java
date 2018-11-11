package com.java.thread;

/**
 * Created by pc on 2018/9/13.
 */

class Clerk {
    private int product;

    public synchronized void addProduct() {
        if (product >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            product++;
            System.out.println(Thread.currentThread().getName()+"生产第" + product + "个产品");
            notifyAll();
        }
    }

    public synchronized void consumePorduct() {
        if (product <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            product--;
            System.out.println(Thread.currentThread().getName()+"消费了第" + (product + 1) + "个产品");
            notifyAll();
        }
    }
}

class Product implements Runnable {
    private Clerk clerk;

    public Product(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}

class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumePorduct();
        }
    }
}

public class PCThread {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Product p = new Product(clerk);
        Consumer c = new Consumer(clerk);
        Thread t1 = new Thread(p);
        Thread t3 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.setName("生产者1");
        t3.setName("生产者2");
        t2.setName("消费者");
        t1.start();
        t2.start();
        t3.start();
    }
}
