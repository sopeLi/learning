package com.jcloud.learn.test.yalmLoadConfig;

import java.util.ArrayList;
import java.util.List;

public class CircuitBreakConfig {
    private CircuitBreakMode mode = CircuitBreakMode.DISABLE;
    private List<ApiItem> whiteList = new ArrayList<>();

    public CircuitBreakConfig() {
    }

    public CircuitBreakMode getMode() {
        return mode;
    }

    public void setMode(CircuitBreakMode mode) {
        this.mode = mode;
    }

    public List<ApiItem> getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(List<ApiItem> whiteList) {
        this.whiteList = whiteList;
    }
}
