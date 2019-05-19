package com.zxz.ebook.service;

import com.zxz.ebook.entity.Book;

import java.util.List;

public interface BookService {
     public List<Book> lookAllBook();
     public List<Book> lookBookLike(String name);
     public Book lookBook(int id);
}
