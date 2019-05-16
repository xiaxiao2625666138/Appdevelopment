package com.ebook.loginRegisterLogout;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import com.jndi.DBUtil;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String uname=request.getParameter("username");
        String upass=request.getParameter("password");
        if(uname.trim().length()==0) {
            out.println(-4);
            return;
        }
        if(upass.trim().length()==0){
            out.println(-3);
            return;
        }

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs=null;

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        conn=DBUtil.getConnectionByJNDI();

        HttpSession session = request.getSession(true);

        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT checkUser(\"" + uname + "\", \"" + upass + "\") as statusNum;";
            rs = stmt.executeQuery(sql);
            rs.next();
            int statusNum=rs.getInt("statusNum");
            if(statusNum >0 ){
                session.setAttribute("username", uname);
                session.setAttribute("islogin", statusNum);
            }
            out.println(statusNum);
            // 完成后关闭
            DBUtil.closeResource(rs, stmt, conn);
        }catch(Exception err){
            if(conn!=null)DBUtil.closeResource(rs, stmt, conn);
            err.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
