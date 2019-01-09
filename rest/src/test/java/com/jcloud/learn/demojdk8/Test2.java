package com.jcloud.learn.demojdk8;

/**
 * 如果一个接口只有一个抽象方法
 * jdk1.8默认为函数式接口
 */
interface TestInterface1 {
    void say(String name);
}

@FunctionalInterface
/**
 * 函数式接口的限制
 * 有且只有一个抽象方法
 * default static不限制
 *
 */
interface TestInterface2 {
    String say(String name, String sex);
}

/**
 * 没有方法的接口是普通的接口
 * 这种接口通常用于标记使用，如java的序列化
 */
interface TestInterface3 {
    void say();
}

class Test2 {
    //如果省略了大括号，return一定要省略
    public static void main(String[] args) {
        TestInterface2 testInterface2 = (name, sex) -> "";
        testInterface2.say("lixin", "男");
    }
}

class Test3 {
    public static void main(String[] args) {
        TestInterface3 testInterface3 = () -> System.out.println("test3");
        testInterface3.say();
    }
}

class Test11 {
    public static void main(String[] args) {
        TestInterface1 testInterface1 = x -> System.out.println("my name is " + x);
        testInterface1.say("李鑫");
    }
}





