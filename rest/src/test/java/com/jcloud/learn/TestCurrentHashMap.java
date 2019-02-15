package com.jcloud.learn;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

public class TestCurrentHashMap {
    private ConcurrentHashMap<String, Integer> partners = new ConcurrentHashMap<>(10);

    @Test
    public void testSelect() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            partners.clear();
            for (int i = 0; i < 10; i++) {
                partners.put("" + i, i);
            }
            for (int i = 0; i < 10; i++) {
                partners.put("" + i, i);
            }
            for (int i = 0; i < 10; i++) {
                partners.put("" + i, i);
            }
            partners.clear();
            System.out.println(partners.size());
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(partners.size());
            for (int i = 0; i < 10; i++) {
                System.out.println(partners.get("" + i));
            }
        });
        thread1.start();
        thread2.start();
        while (true) {

        }
    }
}
