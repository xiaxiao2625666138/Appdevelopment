package com.zxz.ebook.service;

import com.zxz.ebook.entity.Book;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BookService {
     public List<Book> lookAllBook();
     public List<Book> lookBookLike(String name);
     public Book lookBook(int id);
     public Object addBook(HttpServletRequest request);
     public String deleteBook(int id);
     public Object alterBook(HttpServletRequest request);
}
