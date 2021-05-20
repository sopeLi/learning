package com.jcloud.learn.demojdk8;

interface Demo {
    default void testDefault() {
        System.out.println("this is test default!");
    }

    static void testStatic() {
        System.out.println("this is test static!");
    }
}

class DemoImpl implements Demo {

}

/**
 * 子接口可以重写父接口的默认方法
 * 实现类也可重写父接口的默认方法
 *
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(108458771*100);
        System.out.println(Math.multiplyExact(108458771, 100));
    }
}

