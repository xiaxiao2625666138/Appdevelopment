package com.zxz.ebook.serviceimpl;

import com.zxz.ebook.dao.BookimageDao;
import com.zxz.ebook.entity.Book;
import com.zxz.ebook.entity.Writer;
import com.zxz.ebook.service.WriterService;
import com.zxz.ebook.dao.WriterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WriterServiceImpl implements WriterService {

    @Autowired
    private WriterDao writerDao;

    @Autowired
    private BookimageDao bookimageDao;

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
        for(Book book:books){
            book.setBookimage(bookimageDao.findByBookid(book.getId()).getImage());
        }
        return books;
    }
}
