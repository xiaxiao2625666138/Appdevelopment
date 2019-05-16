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

@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs=null;

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        conn=DBUtil.getConnectionByJNDI();

        HttpSession session = request.getSession(true);
        String uname=(String)session.getAttribute("username");

        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT logoutUser(\"" + uname +"\") as statusNum;";
            rs = stmt.executeQuery(sql);
            rs.next();
            session.setAttribute("islogin", 0);
            session.setAttribute("username", "");
            out.println(rs.getInt("statusNum"));
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
