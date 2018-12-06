package com.jcloud.learn.test;

import org.junit.Test;

import java.util.*;

/**
 * Created by lixin32 on 2018/6/18.
 */
public class CollectionTest {
    @Test
    public void listTest() {
    }

    @Test
    public void setTest() {

    }

    @Test
    public void hashMapTest() {

    }

    @Test
    public void concurrentHashMapTest() {
        List testList = new ArrayList();
        testList.add("test");
        Collections.synchronizedList(testList);
    }

    @Test
    public void concurrentLinkedQueue() {

    }

    @Test
    public static void workByEntryTest(Map<String, Object> map) {
        Set<Map.Entry<String, Object>> set = map.entrySet();
        //example1
        for (Map.Entry<String, Object> entry : set) {
            System.out.println(entry.getKey() + "—>" + entry.getValue());
        }

        //example2
        for (Map.Entry<String, Object> me : set) {
            System.out.println(me.getKey() + "—>" + me.getValue());

        }
    }
}
