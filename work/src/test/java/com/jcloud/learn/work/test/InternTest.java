package com.jcloud.learn.work.test;


import org.junit.Test;

/**
 * Created by lixin32 on 2018/5/28.
 */
public class InternTest {
    /**
     * 当调用intern方法时，不管使用什么方式定义一个字符串，都会首先在常量池中查找是否有相应的字符串存在，
     * 如果有，直接返回引用，否则，在常量池中生成相应的字符串并返回引用
     */
    @Test
    public void internTest(){
//        String d="aaa";
//        String e="aaa";
//        System.out.println(d==e);
        String a=new String("aaa");
        String b=new String("aaa");
        String c=b.intern();
        String d="aaa";
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(b==c);
        System.out.println(c==d);
    }
}
