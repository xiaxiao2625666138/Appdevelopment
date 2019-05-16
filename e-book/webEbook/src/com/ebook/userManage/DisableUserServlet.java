package com.ebook.userManage;

import com.jndi.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "AllUserServlet")
public class DisableUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // JDBC 驱动名及数据库 URL

    public DisableUserServlet() {
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
        String uname=(String)request.getParameter("username");
        conn= DBUtil.getConnectionByJNDI();
        try{
            // 执行 SQL 查询
            stmt = conn.createStatement();

            String sql;
            sql = "SELECT disableUser(\""+uname+"\") as disabledStatus;";

            rs = stmt.executeQuery(sql);
            if(rs.next()) {
                out.println(rs.getString("disabledStatus"));
            }else{
                out.println();
            }
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
