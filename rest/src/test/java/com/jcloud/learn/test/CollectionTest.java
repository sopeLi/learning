package com.jcloud.learn.test;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by lixin32 on 2018/6/18.
 */
public class CollectionTest {
    @Test
    public void listTest(){
        List list=new ArrayList();
    }
    @Test
    public  void setTest(){
        Set set=new HashSet();

    }

    @Test
    public void hashMapTest(){
        Map map=new HashMap<Object,Object>();

    }

    @Test
    public void concurrentHashMapTest(){
        List testList=new ArrayList();
        testList.add("test");
        Collections.synchronizedList(testList);
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
    }

    @Test
    public void concurrentLinkedQueue(){
        ConcurrentLinkedQueue concurrentLinkedQueue=new ConcurrentLinkedQueue<Runnable>();

    }

    @Test
    public static void workByEntryTest(Map<String, Object> map) {
        Set<Map.Entry<String, Object>> set = map.entrySet();
        //example1
        for (Iterator<Map.Entry<String, Object>> it = set.iterator(); it
                .hasNext(); ) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it
                    .next();
            System.out.println(entry.getKey() + "—>" + entry.getValue());
        }

        //example2
        for (Map.Entry<String, Object> me : set) {
            System.out.println(me.getKey() + "—>" + me.getValue());

        }
    }
}
