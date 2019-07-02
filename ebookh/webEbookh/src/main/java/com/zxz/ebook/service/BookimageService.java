package com.zxz.ebook.service;

import com.zxz.ebook.entity.Bookimage;

import java.io.UnsupportedEncodingException;

public interface BookimageService {
    /*
    public void initImages();
    public Bookimage getImage(int bookid);
    */

    public void saveBookimage(int bookid, byte[] bookimage);
    public void deleteCover(int bookid);
}
