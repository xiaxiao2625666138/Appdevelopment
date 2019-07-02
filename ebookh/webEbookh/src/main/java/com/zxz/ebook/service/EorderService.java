package com.zxz.ebook.service;

import com.zxz.ebook.Business.Order;
import com.zxz.ebook.Business.OrderStatistics;
import com.zxz.ebook.entity.Eorder;

import java.util.List;

public interface EorderService {
    public List<Order> lookAllOrder();
    public List<Eorder> lookPersonalEorder(String username, String begin, String end);
    public OrderStatistics getPersonalStatistics(String username, String begin, String end);
    public String addEorder(int book_id, String username);
    public String choseEorder(int orderid, String username, String chosen);
    public int addBookNumber(int orderid, String username, int add);
    public String choseAllEorder(String username, String chosen);
    public String deleteEorderFromCart(String username);
    public float payOrder(String username);
    public List<Object> userConsume(String begin , String end);
    public List<Object> bookSaled(String begin, String end);
}
