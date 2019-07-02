package com.zxz.ebook.controller;

import com.zxz.ebook.Business.BookSaled;
import com.zxz.ebook.Business.Order;
import com.zxz.ebook.Business.OrderStatistics;
import com.zxz.ebook.Business.UserConsume;
import com.zxz.ebook.dao.BookimageDao;
import com.zxz.ebook.entity.Book;
import com.zxz.ebook.entity.Eorder;
import com.zxz.ebook.entity.Euser;
import com.zxz.ebook.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.*;
import java.util.List;
import java.util.Set;

@CrossOrigin(allowCredentials = "true")
@RestController
public class AdmController {
    @Autowired
    private BookService bookService;
    @Autowired
    private EuserService euserService;
    @Autowired
    private EorderService eorderService;
    @Autowired
    private WriterService writerService;
    @Autowired
    private BookimageService bookimageService;

    @GetMapping(value="/adm/lookAllEuser")
    public List<Euser> lookAllEuser(){
        return euserService.lookAllEuser();
    }

    @RequestMapping(value="/adm/disableEuser")
    public int disableEuser(HttpServletRequest request){
        String username=request.getParameter("username");
        return euserService.disableUser(username);
    }

    @GetMapping(value="/adm/lookAllOrder")
    public List<Order> lookAllEorder(){
        return eorderService.lookAllOrder();
    }

    @ResponseBody
    @RequestMapping(value="/adm/userConsume")
    public List<UserConsume> userConsume(String begin , String end){
        return eorderService.userConsume(begin, end);
    }

    @ResponseBody
    @RequestMapping(value="/adm/bookSaled")
    public List<BookSaled> bookSaled(String begin , String end){
        return eorderService.bookSaled(begin,end);
    }

    @ResponseBody
    @RequestMapping("/adm/addBook")
    public Object addBook(HttpServletRequest request){
        return bookService.addBook(request);
    }

    /**
     *
     * @param file
     * @return
     */
    @RequestMapping("/adm/upload")
    @ResponseBody
    public Object uploadImage(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            try {
                byte [] image=file.getBytes();
                int bookid=(int)request.getSession().getAttribute("bookid");
                bookimageService.saveBookimage(bookid, image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "fail";
            } catch (IOException e) {
                e.printStackTrace();
                return "fail";
            }
            return "{\"status\": \"ok\"}";
        } else {
            return "{\"status\": \"fail\", \"values\": \"empty file!\"}";
        }
    }

    @ResponseBody
    @RequestMapping("/adm/alterBook")
    public Object alterBook(HttpServletRequest request){
        return bookService.alterBook(request);
    }

    /**
     *
     * @param file
     * @return
     */
    @RequestMapping("/adm/alterCover")
    @ResponseBody
    @Transactional
    public Object alterCover(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            try {
                byte [] image=file.getBytes();
                int bookid=(int)request.getSession().getAttribute("bookid");
                bookimageService.deleteCover(bookid);
                bookimageService.saveBookimage(bookid, image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "fail";
            } catch (IOException e) {
                e.printStackTrace();
                return "fail";
            }
            return "{\"status\": \"ok\"}";
        } else {
            return "{\"status\": \"fail\", \"values\": \"empty file!\"}";
        }
    }

    @ResponseBody
    @RequestMapping("/adm/deleteBook")
    public String deleteBook(int id){
        return bookService.deleteBook(id);
    }
}
