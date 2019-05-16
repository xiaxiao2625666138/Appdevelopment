package com.ebook;

import com.jndi.DBUtil;
import com.tool.Order;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "OrderServlet")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // JDBC 驱动名及数据库 URL

    public OrderServlet() {
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
        conn= DBUtil.getConnectionByJNDI();

        HttpSession session=request.getSession();
        String uname=(String)session.getAttribute("username");
        try{
            // 执行 SQL 查询
            stmt = conn.createStatement();

            String sql;
            sql = "SELECT * FROM allOrder WHERE user_name=\"" + uname+"\" ORDER BY time;";
            rs = stmt.executeQuery(sql);
            JSONArray jsonArr=new JSONArray();
            Order.printOrder(rs, jsonArr);
            out.println(jsonArr);
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
