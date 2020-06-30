package com.java.future;

import java.util.concurrent.*;

/**
 * 通过Callable和Future获取结果
 */
public class TestFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("begin-----------------");
        ExecutorService executor = Executors.newCachedThreadPool();
        TaskTest task = new TaskTest();
        Future<Integer> future = executor.submit(task);
        executor.shutdown();
        System.out.println("主线程");
        //future.get() 会阻塞
        Thread.sleep(3000);
        System.out.println("result===" + future.isDone());
        System.out.println("end---------------");

    }

}

class TaskTest implements Callable<Integer> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        System.out.println("TaskTest 开始计算...");
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
