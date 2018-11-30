package com.jcloud.learn.test;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lixin32 on 2018/6/18.
 */
public class OtherTest {
    @Test
    public void charTest(){
        char c=(char)-0;
        System.out.println(c);
    }
    /** 1字节 8位 so -1**/
    @Test
    public void byteTest(){
        /**
         * -2^(8*1-1)
         */
        byte b=127;
        System.out.println(b);
    }

    /**2字节  16位 有符号位 so -1**/
    @Test
    public void shortTest(){
        /**
         * -2^(8*2-1)------2^(8*2-1)-1
         * -32768----32767
         */
        short s=-32768;
        short i=32767;
    }


    /**4字节 16位 so -1**/
    @Test
    public void intTest(){
        /**
         * -2^(8*4-1)------2^(8*4-1)-1
         */
        int i=2147483647;
    }


    @Test
    public void listTest(){
//        List<Student> students=new ArrayList<Student>();
        Student s=new Student();
        s.setAge(20);
        s.setName("zhangsan");

        Method[] methods= s.getClass().getDeclaredMethods();
        for(Method m:methods){
            System.out.println(m);
            System.out.println(m.getName());
            if("getAge".equals(m.getName())){
                try{
                    System.out.println(m.invoke(s));
                }catch (Exception e){

                }
            }
        }
//        students.add(s);
//        People p=new People();
//        p.setStudentList(students);
//
//        Student ss=new Student();
//        ss.setAge(22);
//        ss.setName("lisi");
//        students.add(ss);
//        System.out.println(students);
//        System.out.println(p.getStudentList());
    }

    @Test
    public void hashMapTest() {
        Map hs=new HashMap();
        hs.put("tt","tt");
        hs.put("tt1","tt1");
        System.out.println(hs.size());
    }

    class People{
        private List<Student> studentList;

        public List<Student> getStudentList() {
            return studentList;
        }

        public void setStudentList(List<Student> studentList) {
            this.studentList = studentList;
        }
    }
    class  Student{
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
