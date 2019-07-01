package com.jcloud.learn.Properties;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    @Test
    public void testClasspathAsteriskPrefixLimit() throws IOException {
//        PropertiesLoaderUtils.
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();      //将首先通过ClassLoader.getResources("")加载目录，
        //将只返回文件系统的类路径不返回jar的跟路径
        //然后进行遍历模式匹配
        Resource[] resources = resolver.getResources("classpath:/pay/*.properties");

        for(Resource resource:resources){
            Properties properties = new Properties();
            System.out.println(resource.getFilename().split("-")[0]);
            properties.load(resource.getInputStream());
        }
        Assert.assertTrue(resources.length == 0);
        //将通过ClassLoader.getResources("asm-license.txt")加载
        //asm-license.txt存在于com.springsource.net.sf.cglib-2.2.0.jar
        resources = resolver.getResources("classpath*:/pay/gatewaryPayRequest-*.properties");
        Assert.assertTrue(resources.length > 0);
        //将只加载文件系统类路径匹配的Resource
        resources = resolver.getResources("classpath*:LICENS*");
        Assert.assertTrue(resources.length == 1);
    }
}
