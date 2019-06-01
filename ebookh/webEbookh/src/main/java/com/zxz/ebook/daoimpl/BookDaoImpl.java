package com.zxz.ebook.daoimpl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zxz.ebook.entity.Book;
import com.zxz.ebook.repository.BookRespository;
import com.zxz.ebook.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRespository bookRespository;

    @Override
    @JsonIgnoreProperties(value = {"version", "language", "price", "saled", "score", "score_num", "onsale"})
    public List<Book> findAll() {
        return bookRespository.findAll();
    }

    @Override
    public List<Book> findByNameContaining(String name) {
        return bookRespository.findByNameContaining(name);
    }

    @Override
    public Book findById(int id) {
        return bookRespository.getOne(id);
    }
}
