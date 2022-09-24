package com.jsoft.mrp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/admin/*")
public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");

//      这里是可以设置返回的json串的字符集的
        servletResponse.setContentType("text/javascript;charset=utf-8");
        System.out.println("doFilter execute");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
