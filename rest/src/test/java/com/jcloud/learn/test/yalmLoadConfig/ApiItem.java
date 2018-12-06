package com.jcloud.learn.test.yalmLoadConfig;

import lombok.Data;

@Data
class ApiItem {
    private String url;
    private int timeout = 1000;
}
