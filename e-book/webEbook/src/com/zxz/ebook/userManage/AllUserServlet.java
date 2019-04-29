package com.zxz.ebook.userManage;

import com.zxz.jndi.DBUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "AllUserServlet")
public class AllUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // JDBC 驱动名及数据库 URL

    public AllUserServlet() {
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
            sql = "SELECT * FROM allUser;";

            rs = stmt.executeQuery(sql);
            JSONArray jsonArr=new JSONArray();
            while(rs.next()){
                JSONObject jsonObj=new JSONObject();
                jsonObj.put("username", rs.getString("user_name"));
                jsonObj.put("phone", rs.getString("phone"));
                jsonObj.put("address", rs.getString("address"));
                jsonObj.put("email", rs.getString("email"));
                jsonObj.put("disabled", rs.getString("disabled"));
                jsonArr.put(jsonObj);
            }
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
