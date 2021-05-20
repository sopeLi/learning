package com.jcloud.learn.designMode.singlePattern;

/**
 * 饿汉模式，不管之后会不会使用到，直接创建相关实例
 */
public class SingletonManager {
    public static final SingletonManager singletonManager = new SingletonManager();

    private SingletonManager() {

    }

    public static SingletonManager getInstance() {
        return singletonManager;
    }
}
