package com.estsoft.springproject.filter;


import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    FilterRegistrationBean<Filter> firstFilter() {
        FilterRegistrationBean<Filter> filter= new FilterRegistrationBean<>(new FirstFilter());

        filter.setFilter(new FirstFilter());
        filter.addUrlPatterns("/books");
        filter.setOrder(1);

        return filter;
    }

    @Bean
    public FilterRegistrationBean<Filter> secondFilter() {
        FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();

        filter.setFilter(new SecondFilter());
        filter.addUrlPatterns("/books");
        filter.setOrder(2);

        return filter;
    }

//    @Bean FilterRegistrationBean<Filter> thirdFilter() {
//        FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
//
//        filter.setFilter(new ThirdFilter());
//        filter.setOrder(3);
//
//        return filter;
//    }
}
