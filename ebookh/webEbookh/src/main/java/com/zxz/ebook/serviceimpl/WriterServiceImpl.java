package com.zxz.ebook.serviceimpl;

import com.zxz.ebook.dao.WriterDao;
import com.zxz.ebook.entity.Book;
import com.zxz.ebook.entity.Writer;
import com.zxz.ebook.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WriterServiceImpl implements WriterService {

    @Autowired
    private WriterDao writerDao;

    @Override
    public List<Writer> lookAllWriter() {
        return writerDao.findAll();
    }

    @Override
    public Set<Book> LookBookByAuthor(String authorName) {
        List<Writer> writers=writerDao.findByNameContaining(authorName);
        Set<Book> books=new HashSet<Book>();
        for(int i=0;i<writers.size();i++){
            books.addAll(writers.get(i).getBooks());
        }
        return books;
    }
}
