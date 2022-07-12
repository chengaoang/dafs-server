package com.sangeng.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

@Configuration
public class MultipartConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        String property = System.getProperty("user.dir");
        // location可以理解为临时文件目录，我们可以通过配置location的值，使其指向我们的项目路径
        factory.setLocation(property+"/src/main/java/com");
        return factory.createMultipartConfig();
    }
}
