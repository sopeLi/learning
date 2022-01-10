package com.jcloud.learn.impl;

import com.jcloud.learn.interfaces.SpiService;

/**
 * @author lixin
 * @description:
 * @date Create in 18:09 2022/1/10
 */
public class ProcessGo implements SpiService {
    @Override
    public String process(String input) {
        return input + "go";
    }
}
