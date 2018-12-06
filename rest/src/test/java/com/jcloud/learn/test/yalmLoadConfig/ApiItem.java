package com.jcloud.learn.test.yalmLoadConfig;

public class ApiItem {
    private String url;
    private int timeout = 1000;

    public ApiItem() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
