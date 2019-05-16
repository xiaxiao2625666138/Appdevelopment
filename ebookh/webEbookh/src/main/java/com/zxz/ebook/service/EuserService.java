package com.zxz.ebook.service;

import com.zxz.ebook.Business.Order;
import com.zxz.ebook.entity.Eorder;
import com.zxz.ebook.entity.Euser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

public interface EuserService {
    /*
    public List<Euser> lookAllEuser();
    public Euser getOneEuser(String username);
    */
    public String loginEuser(HttpServletRequest request, HttpServletResponse response);
    public String registerEuser(String username, String password, String confirmPassword, String email);
    public List<Eorder> getCart(String username);
    public List<Order> getOrders(String username);
    public String logout(HttpServletRequest request);
    public int userType(HttpServletRequest request);

}
