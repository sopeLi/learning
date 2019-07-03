package com.jcloud.learn.yalmLoadConfig;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CircuitBreakConfig {
    private CircuitBreakMode mode = CircuitBreakMode.DISABLE;
    private List<ApiItem> whiteList = new ArrayList<>();

}
