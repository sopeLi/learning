package com.jcloud.learn.test.demojdk;

import java.util.Arrays;
import java.util.function.Consumer;

interface Closeable{
    void close(String test);
}

interface  SortInterface{
    void accept(int []a);
}


public class CloseDoor {
    public void doClose(Closeable closeable,String text){
        closeable.close(text);
    }


    public void doClose1(String name,Consumer<String> consumer){
        consumer.accept(name);
    }
    public static void main(String[] args) {
        CloseDoor closeDoor=new CloseDoor();
        closeDoor.doClose(test -> System.out.println(test),"test");
        closeDoor.doClose(t -> System.out.println(t),"aaaaaaaaaaaa");
        closeDoor.doClose1("lixin",t-> System.out.println(t));

        closeDoor.doClose(t -> System.out.println(t),"aaaaaaaaaaaa");

        SortInterface sortInterface= Arrays::sort;
        int a[]={12,33,44,55};
        sortInterface.accept(a);

        Consumer consumer= (Consumer<Integer[]>) integer -> System.out.println(integer.toString());
        consumer.accept(a);
    }
}
