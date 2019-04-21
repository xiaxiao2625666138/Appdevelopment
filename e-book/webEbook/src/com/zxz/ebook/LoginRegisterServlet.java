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

@WebServlet(name = "LoginRegisterServlet")
public class LoginRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname=request.getParameter("username");
        String upass=request.getParameter("password");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs=null;

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        conn=DBUtil.getConnectionByJNDI();

        HttpSession session = request.getSession(true);
        String islogin= (String) session.getAttribute("islogin");

        try{
            stmt = conn.createStatement();
            String sql;
            if(Integer.valueOf(request.getParameter("fun"))==0) {
                sql = "SELECT checkUser(\"" + uname + "\", \"" + upass + "\") as statusNum;";
                session.setAttribute("islogin", 1);
            }else if(Integer.valueOf(request.getParameter("fun"))==1){
                    if(request.getParameter("cpassword").equals(upass)) {
                        sql = "SELECT registerUser(\"" + uname + "\", \"" + upass + "\") as statusNum;";
                    }else{
                        out.println(-1);
                        return;
                    }
            }else if(Integer.valueOf(request.getParameter("fun"))==2){
                sql = "SELECT logoutUser(\"" + uname +"\") as statusNum;";
                session.setAttribute("islogin", 0);
            }else{
                out.println("error");
                return;
            }
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
