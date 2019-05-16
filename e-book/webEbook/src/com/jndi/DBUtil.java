package com.jndi;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    private DBUtil() {
    }//JNDI方式配置数据源

    public synchronized static Connection getConnectionByJNDI() {
        Connection con = null;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ebook");
            con = ds.getConnection();
        } catch (NamingException e) {
            System.out.println("连接错误！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("获取连接失败！");
            e.printStackTrace();
        }
        return con;
    }

    public static void closeResource(ResultSet rs, Statement stmt, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("关闭资源失败！");
            e.printStackTrace();
        }
    }
}