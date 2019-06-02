package com.zxz.ebook.Business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zxz.ebook.entity.Eorder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {
    public String username;
    public String time;
    public float money;
    public int booknum;
    public List<Eorder> eorders=new ArrayList<Eorder>();
}
