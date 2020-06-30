package com.java.future;

import java.util.concurrent.*;

/**
 * 通过Callable和FutureTask获取结果
 */
public class TestFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("begin------");
        //第一种方式
        /*ExecutorService executor = Executors.newCachedThreadPool();
        TaskTest1 task = new TaskTest1();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        executor.submit(futureTask);
        executor.shutdown();*/

        //第二种方式
        TaskTest1 task = new TaskTest1();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println("main----");
        System.out.println("result=" + futureTask.get());

        System.out.println("end------");
    }
}

class TaskTest1 implements Callable<Integer> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        System.out.println("begin compute...");
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
