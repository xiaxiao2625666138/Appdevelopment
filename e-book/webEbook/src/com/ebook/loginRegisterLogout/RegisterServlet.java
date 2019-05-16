package com.ebook.loginRegisterLogout;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import com.jndi.DBUtil;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname=request.getParameter("username");
        String upass=request.getParameter("password");
        String ucpass=request.getParameter("cpassword");
        String uemail=request.getParameter("email");
        PrintWriter out = response.getWriter();

        if(uname.trim().length()==0) {
            out.println(-4);
            return;
        }
        if(!uemail.matches("\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}")){
            out.println(-3);
            return;
        }
        if(upass.trim().length()==0){
            out.println(-2);
            return;
        }
        if(!upass.equals(ucpass)){
            out.println(-1);
            return;
        }

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs=null;

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        conn=DBUtil.getConnectionByJNDI();

        try{
            String sql;
            sql = "SELECT registerUser(\"" + uname + "\", \"" + upass + "\", \""+uemail+"\") as statusNum;";

            stmt=conn.createStatement();
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
