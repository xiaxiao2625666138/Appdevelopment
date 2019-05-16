
package Util;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {
    // SessionFactory会话工厂
    private static SessionFactory sessionFactory = null;
    // 线程局部变量管理
    private static ThreadLocal threadLocal = new ThreadLocal();

    // 写在static块是因为该块只会被类被ClassLoader加载到虚拟机的时候执行一次
    static {
        try {
            // 使用Configuration()对象.configure()方法去读取src/hibernate.cfg.xml配置文件
            sessionFactory = new Configuration().configure()
                    .buildSessionFactory();// 产生一个SessionFactory
        } catch (Throwable e) {// 如果在执行static块的时候出现任何的Throwable(Error和Exception的类的父类)则处理
            // 抛出明确的static程式错误的异常
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     *
     * 获得SessionFactory
     *
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * 获得Session会话对象
     *
     * @return Session
     */
    public static Session getSession() {
        // 首先从线程局部变量中有没有session,以免还要openSession();
        Session session = (Session) threadLocal.get();
        // 如果是空或者没有打开
        if (session == null || !session.isOpen()) {
            // 则打开(因为static块有可能出错,所以这里进行三元判断)
            session = sessionFactory != null ? sessionFactory.openSession()
                    : null;
            // 设置到线程局部变量中
            threadLocal.set(session);
        }
        return session;
    }

    // 关闭Session
    public static void closeSession() {
        // 获得线程局部变量中的session
        Session session = (Session) threadLocal.get();
        // 设置为空,当再次调用openSession()的时候才能打开Session
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }
    }
}
