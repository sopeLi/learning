package com.jcloud.learn.yalmLoadConfig;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

public class LoadConfig {
    private CircuitBreakConfig config;
    private Person person;

    private LoadConfig() {
        InputStream configInputStream =
                this.getClass().getClassLoader().getResourceAsStream("httpClientCircuitBreak.yml");

        InputStream personConfigInputStream =
                this.getClass().getClassLoader().getResourceAsStream("personcConfig.yml");

        if (configInputStream == null) {
            return;
        }

        Yaml yaml = new Yaml();

        person = yaml.loadAs(personConfigInputStream, Person.class);
        config = yaml.loadAs(configInputStream, CircuitBreakConfig.class);
    }

    public static void main(String[] args) {
        LoadConfig loadConfig=new LoadConfig();
        System.out.println(loadConfig.config);
        System.out.println(loadConfig.person);
    }
}
