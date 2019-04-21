package com.zxz.ebook;

import com.zxz.jndi.DBUtil;
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

@WebServlet(name = "DeatilServlet")
public class AllOrderToPaidServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // JDBC 驱动名及数据库 URL

    public AllOrderToPaidServlet() {
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
        int islogin=(int)session.getAttribute("islogin");
        if(islogin==0){
            out.println(0);
            return;
        }

        try{
            // 执行 SQL 查询
            stmt = conn.createStatement();

            String sql;
            sql = "SELECT * FROM allOrderToPaid WHERE user_name=\"" + uname+"\";";
            rs = stmt.executeQuery(sql);
            JSONArray jsonArr=new JSONArray();
            while(rs.next()){
                JSONObject jsonObj=new JSONObject();
                jsonObj.put("book_id", rs.getInt("book_id"));
                jsonObj.put("book_name", rs.getString("book_name"));
                jsonObj.put("book_num", rs.getInt("book_num"));
                jsonObj.put("subtitle", rs.getString("subtitle"));
                jsonObj.put("version", rs.getInt("version"));
                jsonObj.put("language_name", rs.getString("language_name"));
                jsonObj.put("cover", rs.getString("cover"));
                jsonObj.put("price", new java.text.DecimalFormat("#.0").format(rs.getFloat("price")));
                jsonObj.put("order_id", rs.getInt("order_id"));
                jsonObj.put("chosen", rs.getString("chosen"));
                jsonObj.put("time", rs.getString("time"));
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
