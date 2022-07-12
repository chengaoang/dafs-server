package com.sangeng.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    /**
     * 《改进版》
     * 上传
     * - 相对路径，配classpath
     * 读
     * - outputStream
     * @param registry
     */
    // @Override
    // public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //     log.info("开始静态资源映射！！");
    //     registry.addResourceHandler("/img/**").addResourceLocations("classpath:/upload/img/");
    // }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
      // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                // 是否允许cookie
                .allowCredentials(true)
                // 设置允许的请求方式
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                // 设置允许的header属性
                .allowedHeaders("*")
                // 跨域允许时间
                .maxAge(3600);
    }
}