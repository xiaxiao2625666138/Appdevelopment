package com.zxz.ebook.serviceimpl;

import com.zxz.ebook.dao.BookimageDao;
import com.zxz.ebook.entity.Bookimage;
import com.zxz.ebook.service.BookimageService;
import com.zxz.ebook.tool.ImageToByte;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class BookimageServiceImpl implements BookimageService {

    @Autowired
    private BookimageDao bookimageDao;

    @Override
    public void saveBookimage(int bookid, byte[] image) {
        Bookimage bookimage=new Bookimage();
        bookimage.setBookid(bookid);
        bookimage.setImage(image);
        bookimageDao.insertImage(bookimage);
    }

    @Override
    public void deleteCover(int bookid) {
        bookimageDao.deleteByBookid(bookid);
    }

    /*
    @Override
    public void initImages(){
        String url="D:\\Appdevelopment\\ebookh\\webEbookh\\src\\main\\resources\\static\\img\\b";
        for(int i=1;i<45;i++){
            byte[] image=ImageToByte.image2byte(url+i+".jpg");
            Bookimage bookimage=new Bookimage();
            bookimage.setBookid(i);
            bookimage.setImage(image);
            bookimageDao.insertImage(bookimage);
        }
    }
    */
}
