package com.zxz.ebook.filter;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "userFilter", urlPatterns = {"/user/*"})
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = ((HttpServletRequest)request).getSession(true);
        int islogin= (int) session.getAttribute("islogin");
        if(islogin<=0){
            HttpServletResponse res=(HttpServletResponse) response;
            PrintWriter out=response.getWriter();
            out.println("Please Login!");
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {}

}
