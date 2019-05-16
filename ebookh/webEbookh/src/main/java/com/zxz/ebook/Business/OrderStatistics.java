package com.zxz.ebook.Business;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderStatistics {
    public String username;
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    public Timestamp begin;
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    public Timestamp end;
    public float totalMoney=0;
    public int totalBooknum=0;
    public int totalTime=0;
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    public Timestamp maxTime=Timestamp.valueOf("2000-01-01 00:00:01");
    public float maxMoney=0;
    public List<Order> orders=new ArrayList<Order>();
}
