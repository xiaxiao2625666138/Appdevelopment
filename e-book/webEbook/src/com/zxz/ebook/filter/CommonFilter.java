package com.zxz.ebook.filter;

//导入必需的 java 库
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

//实现 Filter 类
public class CommonFilter implements Filter  {
    public void  init(FilterConfig config) throws ServletException {

    }
    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {
        HttpSession session = ((HttpServletRequest)request).getSession(true);
        if(session.getAttribute("islogin")==null){
            String isloginKey=new String("islogin");
            Integer isloginValue=0;
            session.setAttribute(isloginKey, isloginValue);
        }
        if(session.getAttribute("username")==null){
            String usernameKey=new String("username");
            String usernameValue=new String("");
            session.setAttribute(usernameKey, usernameValue);
        }
        chain.doFilter(request,response);
    }
    public void destroy( ){
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
    }
}