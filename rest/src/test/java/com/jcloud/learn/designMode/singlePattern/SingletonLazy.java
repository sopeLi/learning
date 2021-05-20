package com.jcloud.learn.designMode.singlePattern;

import java.util.Objects;

/**
 * 懒汉模式
 */
public class SingletonLazy {
    public static volatile SingletonLazy singletonLazy = null;

    private SingletonLazy() {

    }

    /**
     * 此方法实现的单例，无法在多线程场景下使用，说明了就是不可用。
     *
     * @return this
     */
    public static SingletonLazy getInstance1() {
        if (Objects.isNull(singletonLazy)) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }

    /**
     * 此方法实现的单例，可以在多线程的情况下使用，但性能不侍，如果此类中还有其他加锁的静态方法，同时调用则会出现阻塞等待的情况
     *
     * @return this
     */
    public static synchronized SingletonLazy getInstance2() {
        if (Objects.isNull(singletonLazy)) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }

    /**
     * 此方法实现的单例，可以多线程的情况下使用
     * 最优解
     *
     * @return this
     */
    public static SingletonLazy getInstance3() {
        if (Objects.isNull(singletonLazy)) {
            synchronized (SingletonLazy.class) {
                if (Objects.isNull(singletonLazy)) {
                    singletonLazy = new SingletonLazy();
                }
            }
        }
        return singletonLazy;
    }
}
