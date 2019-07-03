package com.jcloud.learn.yalmLoadConfig;

import lombok.Data;

@Data
public class ApiItem {
    private String url;
    private int timeout = 1000;
}
