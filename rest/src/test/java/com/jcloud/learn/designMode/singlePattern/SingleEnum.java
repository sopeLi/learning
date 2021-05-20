package com.jcloud.learn.designMode.singlePattern;

public enum SingleEnum {
    SingleEnum("单例的枚举方式");

    private String str;

    SingleEnum(String str) {
        this.str = str;
    }

    public String getInstance() {
        return str;
    }
}
