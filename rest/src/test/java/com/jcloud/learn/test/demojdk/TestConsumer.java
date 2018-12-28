package com.jcloud.learn.test.demojdk;

import java.util.function.Consumer;

public class TestConsumer {



    public void testConsumer1(String[] content, Consumer<String[]> consumer) {
        consumer.accept(content);
    }

    public static void main(String[] args) {
        TestConsumer consumer = new TestConsumer();
        String s[] = {"name", "lixin"};
        consumer.testConsumer1(s, kv -> System.out.println(kv[0] + ":" + kv[1]));
    }
}
