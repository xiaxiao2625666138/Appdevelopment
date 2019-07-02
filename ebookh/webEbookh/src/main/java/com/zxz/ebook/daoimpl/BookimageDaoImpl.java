package com.zxz.ebook.daoimpl;

import com.zxz.ebook.dao.BookimageDao;
import com.zxz.ebook.entity.Bookimage;
import com.zxz.ebook.repository.BookimageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.UnsupportedEncodingException;

@Repository
public class BookimageDaoImpl implements BookimageDao {

    @Autowired
    BookimageRepository bookimageRepository;

    @Override
    public void insertImage(Bookimage bookimage){
        bookimageRepository.insert(bookimage);
    }

    @Override
    public Bookimage findByBookid(int bookid) {
        return bookimageRepository.findByBookid(bookid);
    }

    @Override
    public Object deleteByBookid(int bookid) {
        return bookimageRepository.deleteByBookid(bookid);
    }
}
