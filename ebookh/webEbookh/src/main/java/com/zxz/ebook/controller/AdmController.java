package com.zxz.ebook.controller;

import com.zxz.ebook.Business.Order;
import com.zxz.ebook.Business.OrderStatistics;
import com.zxz.ebook.entity.Book;
import com.zxz.ebook.entity.Eorder;
import com.zxz.ebook.entity.Euser;
import com.zxz.ebook.service.BookService;
import com.zxz.ebook.service.EorderService;
import com.zxz.ebook.service.EuserService;
import com.zxz.ebook.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
}
