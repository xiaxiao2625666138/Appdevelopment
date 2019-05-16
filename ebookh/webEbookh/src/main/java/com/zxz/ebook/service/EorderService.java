package com.zxz.ebook.service;

import com.zxz.ebook.Business.OrderStatistics;
import com.zxz.ebook.entity.Eorder;

import java.sql.Timestamp;
import java.util.List;

public interface EorderService {
    public List<Eorder> lookAllEorder();
    public List<Eorder> lookPersonalEorder(String username, String begin, String end);
    public OrderStatistics getPersonalStatistics(String username, String begin, String end);
}
