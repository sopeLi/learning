package com.jcloud.learn.yalmLoadConfig;

import lombok.Data;

@Data
class ApiItem {
    private String url;
    private int timeout = 1000;
}
