package com.levy.access.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;

/**
 * @author levy
 * @date 2020/12/2
 */

@Configuration
public class DruidConfig {


    /**
     * 注册视图
     */
    @Bean
    @ConditionalOnMissingBean
    public ServletRegistrationBean<Servlet> druidServlet() {
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        // 白名单
        registrationBean.addInitParameter("allow", "");
        // 黑名单
        registrationBean.addInitParameter("deny", "192.168.12.12");
        // 登录druid的信息
        registrationBean.addInitParameter("loginUsername", "levy");
        registrationBean.addInitParameter("loginPassword", "levy");
        // 是否能够重置数据
        registrationBean.addInitParameter("resetEnable", "true");
        return registrationBean;
    }

    /**
     * 注册filter信息
     */
    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<Filter>();
        registrationBean.setFilter(new WebStatFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return registrationBean;
    }
}
