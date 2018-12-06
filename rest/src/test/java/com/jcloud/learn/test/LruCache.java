package com.jcloud.learn.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lixin32 on 2018/8/9.
 * use linkedHashMap to cache
 */
public class LruCache<K, V> extends LinkedHashMap<K, V> {
    private int maxCacheSize;

    private LruCache(int maxCacheSize) {

        // 第三个参数为 accessOrder，默认为false。表示按照按照访问顺序排列元素，最近访问的元素会排雷在队末尾

        super(maxCacheSize, 0.75f, true);

        this.maxCacheSize = maxCacheSize;

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当达到预设缓存上限时删除最老元素
        return this.size() >= maxCacheSize + 1;
    }

    public static void main(String[] args) {
        LruCache<String, String> cache = new LruCache<>(3);

        cache.put("k1", "v1");

        System.out.println("test1:" + cache);

        cache.put("k2", "v2");

        System.out.println("test2:" + cache);

        cache.put("k3", "v3");

        System.out.println("test3:" + cache);

        cache.put("k4", "v4");

        System.out.println("test4:" + cache);

//因为我们在后再对象时，accessOrder设置为true，访问一次 k2，k2对应的元素就会排在队尾部，被看做最新元素

        cache.get("k2");

        System.out.println("test5:" + cache);


        Map<String, String> multiKV = new HashMap<>();

        multiKV.put("k5", "k5");

        multiKV.put("k6", "k6");

        cache.putAll(multiKV);

        System.out.println("test5:" + cache);
    }
}
