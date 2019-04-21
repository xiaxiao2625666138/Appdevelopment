package com.zxz.ebook;

import org.json.JSONArray;
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

import com.zxz.jndi.DBUtil;

@WebServlet(name = "HomeServlet")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HomeServlet() {
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

        HttpSession session = request.getSession(true);

        conn=DBUtil.getConnectionByJNDI();
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT book_id, book_name, cover FROM book";
            rs = stmt.executeQuery(sql);

            JSONArray jsonArr=new JSONArray();
            while(rs.next()){
                JSONObject jsonObj=new JSONObject();
                jsonObj.put("book_id", rs.getInt("book_id"));
                jsonObj.put("book_name", rs.getString("book_name"));
                jsonObj.put("cover", rs.getString("cover"));
                jsonArr.put(jsonObj);
            }
            JSONObject jsonObj=new JSONObject();
            String username="";
            int islogin=(int)session.getAttribute("islogin");
            if(islogin==1)
                username=(String)session.getAttribute("username");
            jsonObj.put("username", username);
            jsonObj.put("islogin", islogin);
            jsonObj.put("bookArr", jsonArr);
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
