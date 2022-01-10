package com.jcloud.learn.Spi;

import java.util.List;
import java.util.ServiceLoader;

import com.google.common.collect.Lists;
import com.jcloud.learn.interfaces.SpiService;

/**
 * @author lixin
 * @description:
 * @date Create in 18:12 2022/1/10
 */
public class SpiTest {
    private List<SpiService> processors = Lists.newArrayList();
    public SpiTest() {
        load();
    }
    /**
     * 加载类
     */
    private void load() {
        ServiceLoader<SpiService> loaders = ServiceLoader.load(SpiService.class);
        for (SpiService spiServiceInterface : loaders) {
            processors.add(spiServiceInterface);
        }
    }
    /**
     * 使用加载的处理器来处理对象
     */
    public void process() {
        for (SpiService spiServiceInterface : processors) {
            System.out.println(spiServiceInterface.process("test--"));
        }
    }
    public static void main(String[] args) {
        SpiTest spiTest = new SpiTest();
        spiTest.process();
    }
}