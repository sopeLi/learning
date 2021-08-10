package com.jcloud.learn;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Created by lixin32 on 2018/6/18.
 */
public class OtherTest {
    @Test
    public void charTest() {
        char c = (char) -0;
        System.out.println(c);
    }

    /**
     * 1字节 8位 so -1
     **/
    @Test
    public void byteTest() {
        /**
         * -2^(8*1-1)
         */
        byte b = 127;
        System.out.println(b);
    }

    /**
     * 2字节  16位 有符号位 so -1
     **/
    @Test
    public void shortTest() {
        /**
         * -2^(8*2-1)------2^(8*2-1)-1
         * -32768----32767
         */
        short s = -32768;
        short i = 32767;
    }


    /**
     * 4字节 16位 so -1
     **/
    @Test
    public void intTest() {
        /**
         * -2^(8*4-1)------2^(8*4-1)-1
         */
        int i = 2147483647;
    }


    @Test
    public void longTest() {
        long a = 100000l;
        long b = 100000000l;
        BigDecimal result = new BigDecimal(b - a).divide(new BigDecimal(b)).multiply(new BigDecimal(100l));
        System.out.println(result.toBigInteger());
    }

    @Test
    public void listTest() {
//        List<Student> students=new ArrayList<Student>();
        Student s = new Student();
        s.setName();
        s.setAge();
        s.setAge();
        s.setName();

        Method[] methods = s.getClass().getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
            System.out.println(m.getName());
            if ("getAge".equals(m.getName())) {
                try {
                    System.out.println(m.invoke(s));
                } catch (Exception ignored) {

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
        Map<String, String> hs = new HashMap<>();
        hs.put("tt", "tt");
        hs.put("tt1", "tt1");
        System.out.println(hs.size());
    }

    @Test
    public void test(){
        Student student=new Student();
        student.setName();
        student.setAge();



    }

    class Student {

        void setName() {
        }

        void setAge() {
        }
    }
    @Test
    public void testSubstring(){
//        return ((HttpMethod) Objects.requireNonNull(request.getMethod())).matches(method.name());
        System.out.println("201905101132043520593".substring(11,19));
    }

    @Test
    public void finallyTest(){
        for (int i = 0; i < 4; i++) {
            try{
                if(i==0){
                    break;
                }
            }catch (Exception e){

            }finally {
                System.out.println(i);
            }
        }
    }
}
