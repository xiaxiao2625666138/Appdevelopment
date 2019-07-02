package com.zxz.ebook.dao;

import com.zxz.ebook.entity.Press;

public interface PressDao {
    public Press saveAndFlush(Press press);
    public Press getByName(String name);
}
