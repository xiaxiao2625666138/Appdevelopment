package com.ebook.filter;

//导入必需的 java 库
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//实现 Filter 类
public class AdmFilter implements Filter  {
    public void  init(FilterConfig config) throws ServletException {

    }
    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)request).getSession(true);
        ((HttpServletResponse)response).setContentType("text/json;charset=UTF-8");
        PrintWriter out=((HttpServletResponse)response).getWriter();
        int islogin=(int)session.getAttribute("islogin");
        if(islogin==1){
            out.println("Have No Administrator Authorization !");
        }else{
            chain.doFilter(request, response);
        }
    }
    public void destroy( ){
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
    }
}