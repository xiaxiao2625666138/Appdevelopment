package com.zxz.ebook.dao;

import com.zxz.ebook.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();
    List<Book> findByNameContaining(String name);
    Book findById(int id);
}
