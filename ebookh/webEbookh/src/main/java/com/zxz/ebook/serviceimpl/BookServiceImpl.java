package com.zxz.ebook.serviceimpl;

import com.zxz.ebook.dao.BookimageDao;
import com.zxz.ebook.dao.PressDao;
import com.zxz.ebook.dao.WriterDao;
import com.zxz.ebook.entity.Book;
import com.zxz.ebook.entity.Press;
import com.zxz.ebook.entity.Writer;
import com.zxz.ebook.service.BookService;
import com.zxz.ebook.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private BookimageDao bookImageDao;

    @Autowired
    private WriterDao writerDao;

    @Autowired
    private PressDao pressDao;

    @Override
    public List<Book> lookAllBook() {
        List<Book> books=bookDao.findAll();
        for (Book book:books) {
            book.setBookimage(bookImageDao.findByBookid(book.getId()).getImage());
        }
        return books;
    }

    @Override
    public List<Book> lookBookLike(String name) {
        List<Book> books=bookDao.findByNameContaining(name);
        for(Book book:books){
            book.setBookimage(bookImageDao.findByBookid(book.getId()).getImage());
        }
        return books;
    }

    @Override
    public Book lookBook(int id) {
        Book book=bookDao.findById(id);
        book.setBookimage(bookImageDao.findByBookid(id).getImage());
        return book;
    }

    @Override
    @Transactional
    public Object addBook(HttpServletRequest request) {
        String isbn=request.getParameter("isbn");
        String bookname=request.getParameter("bookname");
        String subtitle=request.getParameter("subtitle");
        String ver=request.getParameter("version");
        int version=0;
        if(ver!=null && !ver.trim().equals("")){
            version=Integer.valueOf(request.getParameter("version"));
        }
        String language=request.getParameter("language");
        int inventory=0;
        String inv=request.getParameter("inventory");
        if(inv!=null && !inv.trim().equals("")){
            inventory=Integer.valueOf(request.getParameter("inventory"));
        }
        float price=0;
        String pri=request.getParameter("price");
        if(pri!=null && !pri.trim().equals("")){
            price=Float.valueOf(request.getParameter("price"));
        }
        String authorName=request.getParameter("author");
        String translatorName=request.getParameter("translator");
        String publishName=request.getParameter("publish");

        if(isbn==null || isbn.trim().equals("")){
            return "{\"status\": \"fail\", \"msg\":\"isbn is null\"}";
        }
        if(bookname==null || bookname.trim().equals("")){
            return "{\"status\": \"fail\", \"msg\":\" bookname is null\"}";
        }
        if(authorName==null || authorName.trim().equals("")){
            return "{\"status\": \"fail\", \"msg\":\"author is null\"}";
        }
        if(publishName==null || publishName.trim().equals("")){
            return "{\"status\": \"fail\", \"msg\":\"publish is null\"}";
        }
        if(version<=0){
            version=1;
        }
        if(inventory<=0){
            inventory=50;
        }
        if(price<=0){
            price=0;
        }

        Writer author=writerDao.findByName(authorName);
        if(author==null){
            author=new Writer();
            author.setName(authorName);
        }
        Writer translator=writerDao.findByName(translatorName);
        if(translator==null){
            translator=new Writer();
            translator.setName(translatorName);
        }
        Press publish=pressDao.getByName(publishName);
        if(publish==null){
            publish=new Press();
            publish.setName(publishName);
        }
        writerDao.saveAndFlush(author);
        writerDao.saveAndFlush(translator);
        pressDao.saveAndFlush(publish);

        Book book=new Book();
        book.setISBN(isbn);
        book.setName(bookname);
        if(subtitle!=null && !subtitle.trim().equals("")){
            book.setSubtitle(subtitle);
        }
        book.setVersion(version);
        book.setLanguage(language);
        book.setInventory(inventory);
        book.setPrice(price);
        List<Writer> authors=new ArrayList<Writer>();
        authors.add(author);
        book.setAuthors(authors);
        if(translatorName!=null && !translatorName.trim().equals("")){
            List<Writer> translators=new ArrayList<Writer>();
            translators.add(translator);
            book.setTranslators(translators);
        }
        book.setPublish(publish);
        bookDao.saveAndFlush(book);
        request.getSession().setAttribute("bookid", book.getId());
        return book;
    }

    @Override
    @Transactional
    public String deleteBook(int id) {
        try{
            bookImageDao.deleteByBookid(id);
            bookDao.deleteById(id);
            return "delete book with id: "+id;
        }catch(Exception err){
            err.printStackTrace();
            return "delete error!";
        }
    }

    @Override
    @Transactional
    public Object alterBook(HttpServletRequest request) {
        int bookid=Integer.valueOf(request.getParameter("bookid"));
        String isbn=request.getParameter("isbn");
        String bookname=request.getParameter("bookname");
        String subtitle=request.getParameter("subtitle");
        String ver=request.getParameter("version");
        int version=0;
        if(ver!=null && !ver.trim().equals("")){
            version=Integer.valueOf(request.getParameter("version"));
        }
        String language=request.getParameter("language");
        int inventory=-1;
        String inv=request.getParameter("inventory");
        if(inv!=null && !inv.trim().equals("")){
            inventory=Integer.valueOf(request.getParameter("inventory"));
        }
        float price=-1;
        String pri=request.getParameter("price");
        if(pri!=null && !pri.trim().equals("")){
            price=Float.valueOf(request.getParameter("price"));
        }
        String authorName=request.getParameter("author");
        String translatorName=request.getParameter("translator");
        String publishName=request.getParameter("publish");

        Book book=bookDao.findById(bookid);

        if(isbn!=null && !isbn.trim().equals("")){
            book.setISBN(isbn);
        }
        if(bookname!=null && !bookname.trim().equals("")){
            book.setName(bookname);
        }
        if(subtitle!=null && !subtitle.trim().equals("")){
            book.setSubtitle(subtitle);
        }
        if(version>0){
            book.setVersion(version);
        }
        if(language!=null && !language.trim().equals("")){
            book.setLanguage(language);
        }
        if(inventory>=0){
            book.setInventory(inventory);
        }
        if(price>=0){
            book.setPrice(price);
        }
        if(authorName!=null && !authorName.trim().equals("")){
            List<Writer> authors=new ArrayList<Writer>();
            String[] names=authorName.split("_");
            for(String name:names){
                Writer writer=writerDao.findByName(name);
                if(writer==null){
                    writer=new Writer();
                    writer.setName(name);
                    writerDao.saveAndFlush(writer);
                }
                authors.add(writer);
            }
            book.setAuthors(authors);
        }
        if(translatorName!=null && !translatorName.trim().equals("")){
            List<Writer> translators=new ArrayList<Writer>();
            String[] names=translatorName.split("_");
            for(String name:names){
                Writer writer=writerDao.findByName(name);
                if(writer==null){
                    writer=new Writer();
                    writer.setName(name);
                    writerDao.saveAndFlush(writer);
                }
                translators.add(writer);
            }
            book.setTranslators(translators);
        }
        if(publishName!=null && !publishName.trim().equals("")){
            Press press=pressDao.getByName(publishName);
            if(press==null){
                press=new Press();
                press.setName(publishName);
                pressDao.saveAndFlush(press);
            }
            book.setPublish(press);
        }
        bookDao.saveAndFlush(book);
        request.getSession().setAttribute("bookid", book.getId());
        return book;
    }

}
