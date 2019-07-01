package com.jcloud.learn.Example;

import java.util.HashMap;
import java.util.Map;

public class Example049 {
    private int overTime;
    public static Example049 INSTANCE = new Example049();
//    private static int CURRENT_YEAR= Calendar.getInstance().get();

    public static void main(String[] args) {
        Integer integer = 345;
        Map map = new HashMap<>();
        map.put("test", integer);
        Map<String, String> result = map;
        String fee = result.get("test");
        System.out.println(fee);
    }
}
