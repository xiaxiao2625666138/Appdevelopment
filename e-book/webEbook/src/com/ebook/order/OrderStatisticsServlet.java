package com.ebook.order;

import com.jndi.DBUtil;
import com.tool.Order;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "OrderStatisticsServlet")
public class OrderStatisticsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // JDBC 驱动名及数据库 URL

    public OrderStatisticsServlet() {
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
        String time1=(String)request.getParameter("time1");
        String time2=(String)request.getParameter("time2");
        try{
            // 执行 SQL 查询
            stmt = conn.createStatement();
            JSONObject jsonObj=new JSONObject();
            jsonObj.put("time1", time1);
            jsonObj.put("time2", time2);
            if(time1.trim().length()==0)time1="2000";
            if(time2.trim().length()==0)time2="2050";
            String sql;
            sql = "SELECT * FROM orderStatistics WHERE user_name=\"" +
                    uname+"\" and time>=\""+time1+"\" and time<=\""+time2+"\";";
            rs = stmt.executeQuery(sql);
            jsonObj.put("username", uname);
            Order.printOrderStatistics(rs, jsonObj);
            out.println(jsonObj);
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
