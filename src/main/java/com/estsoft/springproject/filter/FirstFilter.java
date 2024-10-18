package com.estsoft.springproject.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("FirstFilter init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FirstFilter doFilter() request");

        // requestURI
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("requestURI: " + request.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("FirstFilter doFilter() response");

    }

    @Override
    public void destory() {
        System.out.println("FirstFilter destory()");
    }
}
