package com.jcloud.learn.controller;

import com.jcloud.learn.annotion.EnableCountTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lixin
 * @description:
 * @date Create in 20:42 2021/5/20
 */
@EnableCountTime
@RestController
@RequestMapping("/test")
public class HelloController {
    @GetMapping("/a")
    public String testA() {
        return "hello a!";
    }
}