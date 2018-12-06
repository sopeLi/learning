package com.jcloud.learn.test.yalmLoadConfig;

import java.util.ArrayList;
import java.util.List;

public class CircuitBreakConfig {
    private CircuitBreakMode mode = CircuitBreakMode.DISABLE;
    private List<ApiItem> whiteList = new ArrayList<>();

    public CircuitBreakConfig() {
    }

    public List<ApiItem> getWhiteList() {
        return whiteList;
    }

}
