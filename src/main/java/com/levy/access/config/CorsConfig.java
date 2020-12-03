package com.levy.access.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author levy
 * @date 2020/12/2
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //允许你拿跨域访问的路径
        registry.addMapping("/**")
                // 允许发动cookie
                .allowCredentials(true)
                // 允许跨域访问的源
                .allowedOrigins("*")
                // 允许请求的方法
                .allowedMethods("POST", "GET", "DELETE", "PUT", "OPTION")
                // 允许的头部设置
                .allowedHeaders("*")
                // 允许的预检时间
                .maxAge(168000);
    }
}
