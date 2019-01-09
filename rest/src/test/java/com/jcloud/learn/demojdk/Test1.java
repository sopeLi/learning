package com.jcloud.learn.demojdk;

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
        Demo demo = new DemoImpl();
        demo.testDefault();
        Demo.testStatic();
    }
}

