package com.jcloud.learn.work.test;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class MessageWorker {


    //定时线程
    private ScheduledExecutorService scheduledQueryExecutorService;

    //线程池，用来执行任务
    private ExecutorService businessOperationPool;

    //执行频率时间
    private long delay = 180000;

    private int businessOperationCorePoolSize = 10;
    //线程池维护线程的最大数量  
    private int businessOperationMaxiNumpoolsize = 100;
    //线程池维护线程所允许的空闲时间  
    private long businessOperationKeepalivetime = 5;
    //线程池维护线程所允许的空闲时间的单位  
    private static final TimeUnit UNIT = TimeUnit.MINUTES;
    //线程池所使用的缓冲队列
    private static final BlockingQueue<Runnable> WORKQUEUE = new ArrayBlockingQueue<Runnable>(10);
    //线程池对拒绝任务的处理策略：AbortPolicy为抛出异常；CallerRunsPolicy为重试添加当前的任务，他会自动重复调用execute()方法；DiscardOldestPolicy为抛弃旧的任务，DiscardPolicy为抛弃当前的任务  
    private static final DiscardPolicy HANDLER = new DiscardPolicy();

    /**
     * start Worker
     * contain 2 threadpool, one is used to query , whitch have one thead;
     * the other one is used to send message and update the status;
     */
    public void start() {
        if (isStarted()) {
            return;
        }
        scheduledQueryExecutorService = Executors
                .newSingleThreadScheduledExecutor();

        businessOperationPool = new ThreadPoolExecutor(businessOperationCorePoolSize, businessOperationMaxiNumpoolsize,
                businessOperationKeepalivetime, UNIT, WORKQUEUE, HANDLER);

        scheduledQueryExecutorService.scheduleWithFixedDelay(getTasks(),
                delay, delay, TimeUnit.MILLISECONDS);

        log.info("sending message worker for payment confirm started......");
    }

    /**
     * 查询并分发执行
     *
     * @return
     */
    private QueryPaymentStatus getTasks() {
        return new QueryPaymentStatus();
    }

    /**
     *
     */
    class QueryPaymentStatus implements Runnable {
        @Override
        public void run() {
            log.info("worker  begine queries payment result. sentAccountStatus = 2 will be queried out");
            try {
                System.out.println("hello__________________________________________________________________________!!!!!!!!!!!!");
            } catch (Exception e) {
                log.error("worker error in querying or dispatching , waiting for the next turn", e);
            }
        }
    }

    /**
     * 关闭Worker
     */
    public void stop() {
        log.warn("stop the Sending Message worker for payment confirm");
        if (scheduledQueryExecutorService != null) {
            scheduledQueryExecutorService.shutdown();
        }
        scheduledQueryExecutorService = null;

        if (businessOperationPool != null) {
            businessOperationPool.shutdown();
        }
        businessOperationPool = null;

    }

    /**
     * 是否已经启动
     *
     * @return
     */
    private boolean isStarted() {
        return scheduledQueryExecutorService != null
                && !scheduledQueryExecutorService.isShutdown()
                && businessOperationPool != null && !businessOperationPool.isShutdown();
    }

    /**
     * @param delay the delay to set
     */
    public void setDelay(long delay) {
        this.delay = delay;
    }

    public void setBusinessOperationPool(ExecutorService businessOperationPool) {
        this.businessOperationPool = businessOperationPool;
    }

    public void setBusinessOperationCorePoolSize(int businessOperationCorePoolSize) {
        this.businessOperationCorePoolSize = businessOperationCorePoolSize;
    }

    public void setBusinessOperationMaxiNumpoolsize(
            int businessOperationMaxiNumpoolsize) {
        this.businessOperationMaxiNumpoolsize = businessOperationMaxiNumpoolsize;
    }

    public void setBusinessOperationKeepalivetime(
            long businessOperationKeepalivetime) {
        this.businessOperationKeepalivetime = businessOperationKeepalivetime;
    }

}
