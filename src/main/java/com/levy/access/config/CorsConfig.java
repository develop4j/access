package com.levy.access.config;

import com.levy.access.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author levy
 * @date 2020/12/2
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(loginInterceptor);
        interceptor.addPathPatterns("/**");
        // 排除指定拦截
        interceptor.excludePathPatterns("/webjars/**");
        interceptor.excludePathPatterns("/webjars/springfox-swagger-ui/**");
        interceptor.excludePathPatterns("/druid/**");
        // swagger
        interceptor.excludePathPatterns("/swagger-ui.html");
        interceptor.excludePathPatterns("/swagger-resources/**");
        interceptor.excludePathPatterns("/v2/api-docs");
        // 登录
        interceptor.excludePathPatterns("/login/userLogin");
        // 验证码
        interceptor.excludePathPatterns("/login/captcha.jpg");
        // 服务监控
        interceptor.excludePathPatterns("/actuator/**");
    }
}
