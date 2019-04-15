package com.zxz.ebook;

import com.zxz.jndi.DBUtil;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "DeatilServlet")
public class DetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // JDBC 驱动名及数据库 URL

    public DetailServlet() {
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
        try{
            // 执行 SQL 查询
            stmt = conn.createStatement();

            String sql;
            sql = "SELECT * FROM allBooks WHERE book_id=" + request.getParameter("book_id")+";";

            rs = stmt.executeQuery(sql);
            rs.next();
            JSONObject jsonObj=new JSONObject();
            jsonObj.put("book_id", rs.getInt("book_id"));
            jsonObj.put("book_name", rs.getString("book_name"));
            jsonObj.put("subtitle", rs.getString("subtitle"));
            jsonObj.put("author_name", rs.getString("author_name"));
            jsonObj.put("translator_name", rs.getString("translator_name"));
            jsonObj.put("press_name", rs.getString("press_name"));
            jsonObj.put("version", rs.getInt("version"));
            jsonObj.put("language_name", rs.getString("language_name"));
            jsonObj.put("cover", rs.getString("cover"));
            jsonObj.put("price", rs.getFloat("price"));
            jsonObj.put("inventory", rs.getInt("inventory"));
            jsonObj.put("saled", rs.getInt("saled"));
            jsonObj.put("score", rs.getFloat("score"));
            jsonObj.put("logos", rs.getString("logos"));
            jsonObj.put("detail", rs.getString("detail"));
            jsonObj.put("author1_name", rs.getString("author1_name"));
            jsonObj.put("author2_name", rs.getString("author2_name"));
            jsonObj.put("author3_name", rs.getString("author3_name"));
            jsonObj.put("translator1_name", rs.getString("translator1_name"));
            jsonObj.put("translator2_name", rs.getString("translator2_name"));
            jsonObj.put("translator3_name", rs.getString("translator3_name"));
            jsonObj.put("author_detail", rs.getString("author_detail"));
            jsonObj.put("author1_detail", rs.getString("author1_detail"));
            jsonObj.put("author2_detail", rs.getString("author2_detail"));
            jsonObj.put("author3_detail", rs.getString("author3_detail"));
            jsonObj.put("translator_detail", rs.getString("translator_detail"));
            jsonObj.put("translator2_detail", rs.getString("translator2_detail"));
            jsonObj.put("translator3_detail", rs.getString("translator3_detail"));

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
