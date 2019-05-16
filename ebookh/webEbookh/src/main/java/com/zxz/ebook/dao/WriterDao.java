package com.zxz.ebook.dao;

import com.zxz.ebook.entity.Writer;

import java.util.List;

public interface WriterDao {
    public List<Writer> findAll();
    public List<Writer> findByNameContaining(String name);
}
