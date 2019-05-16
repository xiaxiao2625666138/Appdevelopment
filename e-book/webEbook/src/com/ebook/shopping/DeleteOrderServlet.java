package com.ebook.shopping;

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

@WebServlet(name = "DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs=null;
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        conn= DBUtil.getConnectionByJNDI();

        HttpSession session = request.getSession(true);
        int islogin=(int)session.getAttribute("islogin");
        if(islogin==0){
            out.println(-1); /* 用户没登陆 */
            return;
        }
        String uname=(String)session.getAttribute("username");
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT deleteOrder(\"" + uname + "\") as statusNum;";
            out.println(sql);
            rs = stmt.executeQuery(sql);
            rs.next();
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
