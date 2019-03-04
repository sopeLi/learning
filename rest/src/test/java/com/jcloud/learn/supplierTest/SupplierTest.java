package com.jcloud.learn.supplierTest;

import org.junit.Test;

import java.util.function.Supplier;

public class SupplierTest {
    interface SystemOutTest {
        void out();
    }

    class SystemOutTestImpl implements SystemOutTest {
        @Override
        public void out() {
            System.out.println("I am is a test!!!");
        }
    }

    public static void outMsg(Supplier<SystemOutTest> supplier) {
        supplier.get().out();
    }

    @Test
    /**
     * 构造方法引用
     */
    public void testSupplier() {
        SupplierTest.outMsg(SystemOutTestImpl::new);
        SystemOutTest systemOutTest=new SystemOutTestImpl();
        SupplierTest.outMsg(() -> systemOutTest);
    }

}
