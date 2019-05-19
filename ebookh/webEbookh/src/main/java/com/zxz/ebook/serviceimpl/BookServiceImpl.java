package com.zxz.ebook.serviceimpl;

import com.zxz.ebook.dao.BookDao;
import com.zxz.ebook.entity.Book;
import com.zxz.ebook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> lookAllBook() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> lookBookLike(String name) {
        return bookDao.findByNameContaining(name);
    }

    @Override
    public Book lookBook(int id) {
        return bookDao.findById(id);
    }


}
