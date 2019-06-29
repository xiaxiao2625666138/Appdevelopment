package com.zxz.ebook.dao;

import com.zxz.ebook.entity.Bookimage;

import java.io.UnsupportedEncodingException;

public interface BookimageDao {
    public void insertImage(Bookimage bookimage);
    public Bookimage findByBookid(int bookid);
}
