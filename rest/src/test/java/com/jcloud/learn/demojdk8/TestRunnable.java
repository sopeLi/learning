package com.jcloud.learn.demojdk8;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.Test;

public class TestRunnable {
    @Test
    public void consumerDemo() {
        Consumer<String> consumerString = (param) -> System.out.println(param);
        Consumer consumer = (param) -> System.out.println(param);
        Consumer consumer1 = param -> System.out.println(param);
        Comparator<String> consumer2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
    }

    @Test
    public void runnableDemo() {
        Runnable runnable = () -> System.out.println("demo1");
        runnable.run();
    }


    @Test
    public void supplierDemo() {
//        Supplier
    }


}
