package com.jcloud.learn.test.demojdk;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;

interface Closeable {
    void close(String test);
}

interface SortInterface {
    void accept(int[] a);
}


public class CloseDoor {
    public void doClose(Closeable closeable, String text) {
        closeable.close(text);
    }


    public void doClose1(String name, Consumer<String> consumer) {
        consumer.accept(name);
    }

    public static void main(String[] args) {
        CloseDoor closeDoor = new CloseDoor();
        closeDoor.doClose(test -> System.out.println(test), "test");
        closeDoor.doClose(t -> System.out.println(t), "aaaaaaaaaaaa");
        closeDoor.doClose1("lixin", t -> System.out.println(t));

        closeDoor.doClose(t -> System.out.println(t), "aaaaaaaaaaaa");

        SortInterface sortInterface = Arrays::sort;
        int a[] = {12, 33, 44, 55};
        sortInterface.accept(a);

        Consumer consumer = (Consumer<Integer[]>) integer -> System.out.println(integer.toString());
        consumer.accept(a);
        Integer i = null;

        Optional.of(i);
        Optional.of(closeDoor);
    }

    @Test
    public void testOption() {
        Long i = new Long(25);
        Optional<Long> optionalCloseable = Optional.empty();
        Long t = optionalCloseable.orElse(i);
        Consumer consumer = System.out::print;
        consumer.accept(t);
    }

    @Test
    public void testOutPrint() {
        OutPrint outPrint = PrintStream::print;
        outPrint.out(System.out, "hello every one");
    }

    interface OutPrint {
        void out(PrintStream stream, String test);
    }

    @Test
    public void testStringNew(){
        StringNew stringNew=String::new;
        String str=stringNew.build(new char[]{'a','b'});
        System.out.println(str);
    }

    interface StringNew {
        String build(char [] chars);
    }
}
