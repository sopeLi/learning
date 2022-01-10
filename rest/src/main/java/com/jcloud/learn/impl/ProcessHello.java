package com.jcloud.learn.impl;

import com.jcloud.learn.interfaces.SpiService;

/**
 * @author lixin
 * @description:
 * @date Create in 18:08 2022/1/10
 */
public class ProcessHello implements SpiService {
    @Override
    public String process(String input) {
        return input + "hello";
    }
}
