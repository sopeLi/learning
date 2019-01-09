package com.jcloud.learn.demojdk8;

public class TestLambdaRefAndConstruct {

    public static void main(String[] args) {
        TestClassMethodRef1 testClassMethodRef = e -> TestLambdaRefAndConstruct.output1(e);
        testClassMethodRef.test1("hello Test1");

        TestClassMethodRef1 testClassMethodRef1 = TestLambdaRefAndConstruct::output1;
        testClassMethodRef1.test1("hello Test1");

        TestClassMethodRef2 testClassMethodRef2 = TestLambdaRefAndConstruct::output2;
        testClassMethodRef2.test2("hello str1", "str2");

    }

    private static void output1(String str) {
        System.out.println(str);
    }

    private static void output2(String str, String str2) {
        System.out.println(str + str2);
    }

}

@FunctionalInterface
interface TestClassMethodRef1 {
    void test1(String str);
}


@FunctionalInterface
interface TestClassMethodRef2 {
    void test2(String str, String str2);
}
