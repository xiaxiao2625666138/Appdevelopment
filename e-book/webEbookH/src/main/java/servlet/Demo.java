package servlet;

import ebook.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import Util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DemoServlet")
public class Demo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // JDBC 驱动名及数据库 URL
    public Demo() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONArray jsonArr=new JSONArray();

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query query=session.createQuery("from Book");
            List<Book> list=query.list();
            session.getTransaction().commit();
            for(int i=0;i<list.size();i++){
                Book book=list.get(i);
                JSONObject jsonObj=new JSONObject();

                jsonObj.put("name", book.getName());
                jsonObj.put("id", book.getId());
                jsonObj.put("cover", book.getCover());
                jsonObj.put("subtitle", book.getSubtitle());
                jsonObj.put("publish", book.getPublish().getName());
                jsonObj.put("language", book.getLanguage());

                jsonArr.put(jsonObj);
            }
            out.println(jsonArr);
        } catch (Exception e) {
            e.printStackTrace();
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