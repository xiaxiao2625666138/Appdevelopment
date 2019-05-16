package com.zxz.ebook.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "commonFilter", urlPatterns = {"/*"})
public class CommonFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = ((HttpServletRequest)request).getSession(true);
        if(session.getAttribute("username")==null){
            String usernameKey=new String("username");
            String usernameValue=new String("");
            session.setAttribute(usernameKey, usernameValue);
        }
        if(session.getAttribute("islogin")==null){
            String isloginKey=new String("islogin");
            int isloginValue=0;
            session.setAttribute(isloginKey, isloginValue);
        }
        session.setMaxInactiveInterval(30*60);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {}

}
