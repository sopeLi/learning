package com.jcloud.learn.ThreadUse;

import lombok.Data;

import java.util.concurrent.*;

@Data
public class CallableDemo implements Callable<String> {
    private String msg;

    public static void main(String[] args) throws ExecutionException {
        //创建一个定长的核心线程和最大线程数都是1的FixedThreadPool线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CallableDemo callable1 = new CallableDemo();
        callable1.setMsg("test1");
        CallableDemo callable2 = new CallableDemo();
        callable2.setMsg("test2");
        CallableDemo callable3 = new CallableDemo();
        callable3.setMsg("test3");

        // 执行任务并获取Future对象
        Future<String> future1 = executorService.submit(callable1);
        Future<String> future2 = executorService.submit(callable2);
        Future<String> future3 = executorService.submit(callable3);

        try {
            //future.get()线程结果，会阻塞当前线程直到线程结束
            System.out.println("future.get()=" + future1.get());
            System.out.println("future.get()=" + future2.get());
            System.out.println("future.get()=" + future3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");

        // 关闭线程池
        executorService.shutdown();
    }


    @Override
    public String call() throws Exception {
        System.out.println("start" + "\tmsg:" + msg);
        Thread.sleep(3000);
        System.out.println("Thread_current=" + Thread.currentThread());
        return msg;
    }
}
