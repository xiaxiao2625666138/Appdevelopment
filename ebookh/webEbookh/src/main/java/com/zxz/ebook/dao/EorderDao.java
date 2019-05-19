package com.zxz.ebook.dao;

import com.zxz.ebook.entity.Eorder;

import java.sql.Timestamp;
import java.util.List;

public interface EorderDao {
    public List<Eorder> findAll();
    public List<Eorder> findPersonalEorder(String username, Timestamp begin, Timestamp end);
    public void addEorder(int book_id, String user_name, Timestamp time);
    public Eorder getOne(String username, int bookid, String paid);
    public Eorder getOneById(int id, String paid);
    public void deleteById(int id);
    public List<Eorder> getPersonalEorderByPaid(String username, String paid);
    public void deleteEorderByUsername(String username, String paid, String chosen);
    public List<Eorder> getPersonalEorderByPaidAndChosen(String useranme, String paid, String chosen);
}
