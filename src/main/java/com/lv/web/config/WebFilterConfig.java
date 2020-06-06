package com.lv.web.config;


import com.lv.web.filter.SessionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author lv
 * 自定义filter配置类
 */
@Configuration
public class WebFilterConfig {

    @Bean
    public FilterRegistrationBean SessionFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(SessionFilter());
        registration.addUrlPatterns("*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("SessionFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public Filter SessionFilter() {
        return new SessionFilter();
    }
}

