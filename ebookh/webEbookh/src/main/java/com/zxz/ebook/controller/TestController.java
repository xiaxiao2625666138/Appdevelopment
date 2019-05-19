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
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value="/lookAllBook")
    public List<Book> lookAllBook(){
        return bookService.lookAllBook();
    }


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

    @RequestMapping("/lookBookById")
    public Book lookBookById(int id){
        return bookService.lookBook(id);
    }

    @RequestMapping("user/addEorder")
    public String addEorder(HttpServletRequest request){
        int bookid=Integer.valueOf(request.getParameter("bookid"));
        HttpSession session=request.getSession(true);
        String username=(String)session.getAttribute("username");
        return eorderService.addEorder(bookid, username);
    }

    @RequestMapping("/getPersonalCart")
    public List<Eorder> getPersonalCart(HttpServletRequest request){
        HttpSession session=request.getSession(true);
        String username=(String)session.getAttribute("username");
        return euserService.getCart(username);
    }

    @RequestMapping("/user/choseEorder")
    public String choseEorder(HttpServletRequest request){
        HttpSession session=request.getSession(true);
        String username=(String)session.getAttribute("username");
        int orderid=Integer.valueOf(request.getParameter("orderid"));
        String chosen=request.getParameter("chosen");
        return eorderService.choseEorder(orderid, username, chosen);
    }

    @RequestMapping("/user/choseAllEorder")
    public String choseAllEorder(HttpServletRequest request){
        HttpSession session=request.getSession(true);
        String username=(String)session.getAttribute("username");
        String chosen=request.getParameter("chosen");
        return eorderService.choseAllEorder(username, chosen);
    }

    @RequestMapping("/user/addBookNumber")
    public int addBookNumber(HttpServletRequest request){
        HttpSession session=request.getSession(true);
        String username=(String)session.getAttribute("username");
        int orderid=Integer.valueOf(request.getParameter("orderid"));
        int add=Integer.valueOf(request.getParameter("add"));
        return eorderService.addBookNumber(orderid, username, add);
    }

    @RequestMapping("/user/deleteEorder")
    public String deleteEorder(HttpServletRequest request){
        HttpSession session=request.getSession(true);
        String username=(String)session.getAttribute("username");
        return eorderService.deleteEorderFromCart(username);
    }

    @RequestMapping("user/payOrder")
    public float payEorder(HttpServletRequest request){
        HttpSession session=request.getSession(true);
        String username=(String)session.getAttribute("username");
        return eorderService.payOrder(username);
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
