package com.zxz.ebook.Business;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderStatistics {
    public String username;
    public String begin;
    public String end;
    public float totalMoney=0;
    public int totalBooknum=0;
    public int totalTime=0;
    public String maxTime;
    public float maxMoney=0;
    public List<Order> orders=new ArrayList<Order>();
}
