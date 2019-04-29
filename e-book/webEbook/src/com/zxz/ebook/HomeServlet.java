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
import java.net.URLDecoder;
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
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);
        String filter=(String)request.getParameter("filter");
        int islogin=(int)session.getAttribute("islogin");

        conn=DBUtil.getConnectionByJNDI();
        try{
            stmt = conn.createStatement();
            String sql= "SELECT * FROM bookBrowse WHERE true";
            if(islogin!=2){
                sql=sql+" and inventory>0 and onsale='Y'";
            }
            if(filter.equals("author")){
                String name=new String(request.getParameter("author")
                        .getBytes("iso-8859-1"),"UTF-8");
                sql=sql+" and author_name like \"%"
                        +name+"%\" or author1_name like \"%"+name+"%\" or author2_name like \"%"+name
                        +"%\" or author3_name like \"%"+name+"%\";";
            }else if(filter.equals("bookname")){
                String bookname=new String(request.getParameter("bookname")
                        .getBytes("iso-8859-1"),"UTF-8");
                sql=sql+ " and book_name like \"%"+bookname+"%\";";
            }else if(filter.equals("onsale")){
                sql=sql+" and onsale="+"\'"+(String)request.getParameter("onsale")+"\';";
            }
            rs = stmt.executeQuery(sql);

            JSONArray jsonArr=new JSONArray();
            while(rs.next()){
                JSONObject jsonObj=new JSONObject();
                jsonObj.put("book_id", rs.getInt("book_id"));
                jsonObj.put("book_name", rs.getString("book_name"));
                jsonObj.put("subtitle", rs.getString("subtitle"));
                jsonObj.put("cover", rs.getString("cover"));
                jsonObj.put("ISBN", rs.getString("ISBN"));
                jsonObj.put("author_name", rs.getString("author_name"));
                jsonObj.put("author1_name", rs.getString("author1_name"));
                jsonObj.put("author2_name", rs.getString("author2_name"));
                jsonObj.put("author3_name", rs.getString("author3_name"));
                jsonObj.put("inventory", rs.getInt("inventory"));
                jsonObj.put("onsale", rs.getString("onsale"));
                jsonArr.put(jsonObj);
            }
            JSONObject jsonObj=new JSONObject();
            String username=(String)session.getAttribute("username");
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
