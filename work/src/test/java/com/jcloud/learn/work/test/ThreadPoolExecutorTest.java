package com.jcloud.learn.work.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by lixin32 on 2018/6/23.
 */
public class ThreadPoolExecutorTest {

    @Test
    public void threadPoolExecutorTest() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(5, 90, 1, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(10),new ThreadPoolExecutor.AbortPolicy());
        List<Future> features=new ArrayList<Future>();
        for(int i=0;i<100;i++){
            final int temp=i;
            Future future= executor.submit(new CallableTask(i));
            features.add(future);
            try{
                if(i==50){
                    System.out.println("test");
                    executor.shutdown();
                }
            }catch (Exception e){
                System.out.println(e.getCause());
            }

//            Object s = future.get();
//            System.out.println("run"+i+" result:"+s);
        }
        while (true){
            System.out.println("TaskCount"+executor.getActiveCount());
            System.out.println("completedTaskCount"+executor.getCompletedTaskCount());
        }
    }
    class CallableTask implements Callable<Boolean>,Comparable{
        int i;
        public CallableTask(int i){
            this.i=i;
        }
        public Boolean call() throws Exception {
            Thread.currentThread().sleep(1000);
            System.out.println(Thread.currentThread().getName()+"|||||||||||||||"+i);
            return true;
        }

        public int compareTo(Object o) {
            return 0;
        }
    }

}
