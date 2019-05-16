package com.zxz.ebook.daoimpl;

import com.zxz.ebook.dao.BookDao;
import com.zxz.ebook.entity.Book;
import com.zxz.ebook.repository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRespository bookRespository;

    @Override
    public List<Book> findAll() {
        return bookRespository.findAll();
    }

    @Override
    public List<Book> findByNameContaining(String name) {
        return bookRespository.findByNameContaining(name);
    }
}
