package com.zxz.ebook.controller;

import com.zxz.ebook.Business.Order;
import com.zxz.ebook.Business.OrderStatistics;
import com.zxz.ebook.entity.Book;
import com.zxz.ebook.entity.Eorder;
import com.zxz.ebook.entity.Euser;
import com.zxz.ebook.entity.Writer;
import com.zxz.ebook.service.BookService;
import com.zxz.ebook.service.EorderService;
import com.zxz.ebook.service.EuserService;
import com.zxz.ebook.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@CrossOrigin(allowCredentials = "true")
@RestController
public class TestController {
    @Autowired
    private BookService bookService;
    @Autowired
    private EuserService euserService;
    @Autowired
    private EorderService eorderService;
    @Autowired
    private WriterService writerService;

    /*

    @RequestMapping("/hello")
    public String say(){
        return "Hello SpringBoot!";
    }

    @RequestMapping(value="/lookAllBook")
    public List<Book> lookAllBook(){
        return bookService.lookAllBook();
    }

    @GetMapping(value="/lookAllEuser")
    public List<Euser> lookAllEuser(){
        return euserService.lookAllEuser();
    }

    @GetMapping(value="/lookAllEorder")
    public List<Eorder> lookAllEorder(){
        return eorderService.lookAllEorder();
    }

    @GetMapping(value="/lookAllWriter")
    public List<Writer> lookAllWriter(){
        return writerService.lookAllWriter();
    }

    @RequestMapping("/getOneEuser")
    public Euser getOneEuser(String username){
        return euserService.getOneEuser(username);
    }

    @RequestMapping("/lookPersonalEorder")
    public List<Eorder> lookPersonalEorder(String username, String begin, String end){
        return eorderService.lookPersonalEorder(username, begin, end);
    }
    */


    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        return euserService.loginEuser(request, response);
    }

    @RequestMapping("/register")
    public String register(String username, String password, String confirmPassword, String email){
        return euserService.registerEuser(username, password, confirmPassword, email);
    }

    @RequestMapping("/logout")
    public String logou(HttpServletRequest request){
        return euserService.logout(request);
    }

    @RequestMapping("/userType")
    public int userType(HttpServletRequest request){
        return euserService.userType(request);
    }

    @RequestMapping("/lookBookLike")
    public List<Book> lookBookLike(String bookname){
        return bookService.lookBookLike(bookname);
    }

    @RequestMapping("/lookBookBy")
    public Set<Book> lookBookBy(String authorName){
        return writerService.LookBookByAuthor(authorName);
    }

    @RequestMapping("/getPersonalCart")
    public List<Eorder> getPersonalCart(String username){
        return euserService.getCart(username);
    }

    @ResponseBody
    @RequestMapping("/getPersonalOrder")
    public List<Order> getPersonalOrder(String username){
        return euserService.getOrders(username);
    }

    @ResponseBody
    @RequestMapping("/getPersonalOrderStatistics")
    public OrderStatistics getPersonalStatistics(String username, String begin, String end){
        return eorderService.getPersonalStatistics(username, begin, end);
    }

}
