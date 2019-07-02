package com.zxz.ebook.dao;

import com.zxz.ebook.Business.BookSaled;
import com.zxz.ebook.Business.UserConsume;
import com.zxz.ebook.entity.Eorder;

import java.util.List;

public interface EorderDao {
    public List<Eorder> findAll(String paid);
    public List<Eorder> findPersonalEorder(String username, String begin, String end);
    public void addEorder(int book_id, String user_name, String time);
    public Eorder getOne(String username, int bookid, String paid);
    public Eorder getOneById(int id, String paid);
    public void deleteById(int id);
    public List<Eorder> getPersonalEorderByPaid(String username, String paid);
    public void deleteEorderByUsername(String username, String paid, String chosen);
    public List<Eorder> getPersonalEorderByPaidAndChosen(String useranme, String paid, String chosen);
    List<Object> userConsume(String begin , String end);
    List<Object> bookSaled(String begin, String end);
}
