package com.jcloud.learn.demojdk8;

import java.util.function.Predicate;

import org.junit.Test;

/**
 * @author lixin
 * @description:
 * @date Create in 19:57 2021/4/19
 */
public class PredicateTest {
    @Test
    public void test() {
        Predicate<Integer> predicate = (x) -> x > 0;
        System.out.println(predicate.test(20));
    }
}
