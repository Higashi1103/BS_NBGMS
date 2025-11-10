package com.example.demo.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String path = req.getRequestURI();

        System.out.println("LoginFilter working → " + path); // 测试输出

        // 白名单
        if (path.startsWith("/login") ||
            path.startsWith("/loginCheck") ||
            path.startsWith("/logout") ||
            path.startsWith("/css/") ||
            path.startsWith("/js/") ||
            path.startsWith("/image/") ||
            path.equals("/")) {
            chain.doFilter(request, response);
            return;
        }

        // 检查 session
        Object currentYuza = req.getSession().getAttribute("currentYuza");
        if (currentYuza == null) {
            res.sendRedirect("/login");
            return;
        }

        chain.doFilter(request, response);
    }
}