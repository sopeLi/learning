package com.jcloud.learn;

import com.github.rholder.retry.*;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.rmi.RemoteException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by lixin32 on 2018/6/1.
 */
public class GuavaTest {

    @Test
    public void ImmutableCollectionsTest() {
        Set<String> set = new HashSet<>(Arrays.asList("RED", "GREEN"));
        Set<String> unmodifiableSet = Collections.unmodifiableSet(set);///对源对象操作还会对immutableSet有影响
        /**guava collection use
         * 对源对象操作还会对immutableSet有影响 but
         * **/
//        ImmutableSet<Set<String>> unImmutableSet = ImmutableSet.of(set);

        // 可以使用下面的方法
        // ImmutableSet<String> immutableSet = ImmutableSet.of("RED", "GREEN");
        ImmutableSet<String> immutableSet = ImmutableSet.copyOf(set);//真正实现了操作源set不会对immutableSet影响
        set.add("test");
        System.out.println(unmodifiableSet);
        System.out.println(immutableSet);
    }


    @Test
    public void MultisetUseTest() {
        List<String> wordList = new ArrayList<>();
        wordList.add("hello");
        wordList.add("hello");
        wordList.add("hello");
        wordList.add("world");
        HashMultiset<String> multiSet = HashMultiset.create();
        multiSet.addAll(wordList);
        //count word “the”
        Integer count = multiSet.count("hello");
        System.out.println(count);
    }

    @Test
    public void hashMultiMapTest() {
        HashMap<String, HashSet<String>> hMap = new HashMap<>();
        List<Ticket> tickets;
        tickets = new ArrayList<>();
        Ticket t = new Ticket();
        t.setCandidate();
        t.setVoter("zhangSan");
        tickets.add(t);
        Ticket t1 = new Ticket();
        t1.setCandidate();
        t1.setVoter("lisi");
        tickets.add(t1);
        for (Ticket ticket : tickets) {
            HashSet<String> set = hMap.computeIfAbsent(ticket.getCandidate(), k -> new HashSet<>());
            set.add(ticket.getVoter());
        }
        System.out.println(hMap);
        System.out.println("===============================================");
        /** guava 的 hashMultiMap **/
        HashMultimap<String, String> map = HashMultimap.create();
        for (Ticket ticket : tickets) {
            map.put(ticket.getCandidate(), ticket.getVoter());
        }

        System.out.println(map);
    }

    private class Ticket {
        private String candidate;
        private String voter;

        String getCandidate() {
            return candidate;
        }

        void setCandidate() {
            this.candidate = "lixin";
        }

        String getVoter() {
            return voter;
        }

        void setVoter(String voter) {
            this.voter = voter;
        }

    }

    @Test
    public void splitTEst() {
        String args[] = ",a,,b,".split(",");
        System.out.println(Arrays.toString(args));
        Iterable<String> result = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split(",a,,b,");
        System.out.println(result);
    }

    /**
     * 简单三步就能使用Guava Retryer优雅的实现重调方法。
     * <p>
     * 　　接下来对其进行详细说明：
     * 　　RetryerBuilder是一个factory创建者，可以定制设置重试源且可以支持多个重试源，可以配置重试次数或重试超时时间，以及可以配置等待时间间隔，创建重试者Retryer实例。
     * <p>
     * 　　RetryerBuilder的重试源支持Exception异常对象 和自定义断言对象，通过retryIfException 和retryIfResult设置，同时支持多个且能兼容。
     * <p>
     * 　　retryIfException，抛出runtime异常、checked异常时都会重试，但是抛出error不会重试。
     * <p>
     * 　　retryIfRuntimeException只会在抛runtime异常的时候才重试，checked异常和error都不重试。
     * <p>
     * 　　retryIfExceptionOfType允许我们只在发生特定异常的时候才重试，比如NullPointerException和IllegalStateException都属于runtime异常，也包括自定义的error
     * <p>
     * 　　如：
     * .retryIfExceptionOfType(Error.class)// 只在抛出error重试
     * 　　当然我们还可以在只有出现指定的异常的时候才重试，如：
     * <p>
     * .retryIfExceptionOfType(IllegalStateException.class)
     * .retryIfExceptionOfType(NullPointerException.class)
     * 　　或者通过Predicate实现
     * <p>
     * .retryIfException(Predicates.or(Predicates.instanceOf(NullPointerException.class),
     * Predicates.instanceOf(IllegalStateException.class)))
     * 　　retryIfResult可以指定你的Callable方法在返回值的时候进行重试，如
     * <p>
     * // 返回false重试
     * .retryIfResult(Predicates.equalTo(false))
     * //以_error结尾才重试
     * .retryIfResult(Predicates.containsPattern("_error$"))
     * 当发生重试之后，假如我们需要做一些额外的处理动作，比如发个告警邮件啥的，那么可以使用RetryListener。每次重试之后，
     * guava-retrying会自动回调我们注册的监听。可以注册多个RetryListener，会按照注册顺序依次调用。
     */
    @Test
    public void guavaRetryTest() throws ExecutionException, RetryException {
        Callable<Boolean> updateReimAgentsCall = () -> {
            String result = "result";
            if (StringUtils.isEmpty(result)) {
                throw new RemoteException("获取OA可报销代理人接口异常");
            }
//            List<Object> oaReimAgents = JSON.parseArray(result, Object.class);
            return CollectionUtils.isEmpty(new ArrayList<>(2));
        };

        Retryer<Boolean> retryer = RetryerBuilder
                .<Boolean>newBuilder()
                //抛出runtime异常、checked异常时都会重试，但是抛出error不会重试。
                .retryIfException()

                //返回false也需要重试
                .retryIfResult(aBoolean -> Objects.equals(aBoolean, false))
                //重调策略
                .withWaitStrategy(WaitStrategies.fixedWait(10, TimeUnit.SECONDS))
                //尝试次数
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))

                .withRetryListener(new MyRetryListener())

                .build();
        retryer.call(updateReimAgentsCall);
    }


    class MyRetryListener implements RetryListener {

        public <Boolean> void onRetry(Attempt<Boolean> attempt) {

            // 第几次重试,(注意:第一次重试其实是第一次调用)
            System.out.print("[retry]time=" + attempt.getAttemptNumber());

            // 距离第一次重试的延迟
            System.out.print(",delay=" + attempt.getDelaySinceFirstAttempt());

            // 重试结果: 是异常终止, 还是正常返回
            System.out.print(",hasException=" + attempt.hasException());
            System.out.print(",hasResult=" + attempt.hasResult());

            // 是什么原因导致异常
            if (attempt.hasException()) {
                System.out.print(",causeBy=" + attempt.getExceptionCause().toString());
            } else {
                // 正常返回时的结果
                System.out.print(",result=" + attempt.getResult());
            }

            // bad practice: 增加了额外的异常处理代码
            try {
                Boolean result = attempt.get();
                System.out.print(",rude get=" + result);
            } catch (ExecutionException e) {
                System.err.println("this attempt produce exception." + e.getCause().toString());
            }

            System.out.println();
        }
    }

    /**
     * 字符串截取公共部分
     */
    @Test
    public void prefixStringTest(){
        //截取字符串公共前缀
        String commonPrefix = Strings.commonPrefix("fenglang", "fengyue");
        System.out.println(commonPrefix);

        // 判断字符串是否为NULL或空
        boolean nullOrEmpty = Strings.isNullOrEmpty("feng");
        System.out.println(nullOrEmpty);
        Integer a = 126;

        Integer b = 126;
        System.out.println(a==b);

    }
}
