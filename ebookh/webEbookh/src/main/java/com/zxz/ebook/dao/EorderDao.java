package com.zxz.ebook.dao;

import com.zxz.ebook.entity.Eorder;

import java.sql.Timestamp;
import java.util.List;

public interface EorderDao {
    public List<Eorder> findAll();
    public List<Eorder> findPersonalEorder(String username, Timestamp begin, Timestamp end);
}
