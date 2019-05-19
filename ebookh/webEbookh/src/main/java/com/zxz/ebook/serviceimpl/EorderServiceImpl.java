package com.zxz.ebook.serviceimpl;

import com.zxz.ebook.Business.Order;
import com.zxz.ebook.Business.OrderStatistics;
import com.zxz.ebook.dao.BookDao;
import com.zxz.ebook.dao.EorderDao;
import com.zxz.ebook.entity.Book;
import com.zxz.ebook.entity.Eorder;
import com.zxz.ebook.repository.EorderRespository;
import com.zxz.ebook.service.EorderService;
import com.zxz.ebook.tool.OrderTool;
import com.zxz.ebook.tool.TimeTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class EorderServiceImpl implements EorderService {

    @Autowired
    private EorderDao eorderDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private JpaRepository<Eorder, Integer> jpaRepository;

    @Autowired
    private JpaRepository<Book, Integer> bookJpaRepository;

    @Override
    public List<Eorder> lookAllEorder() {
        return eorderDao.findAll();
    }

    @Override
    public List<Eorder> lookPersonalEorder(String username, String begin, String end) {
        return eorderDao.findPersonalEorder(username, Timestamp.valueOf(begin), Timestamp.valueOf(end));
    }

    @Override
    public OrderStatistics getPersonalStatistics(String username, String begin, String end) {
        List<Eorder> eorders=eorderDao.findPersonalEorder(username, Timestamp.valueOf(begin), Timestamp.valueOf(end));
        List<Order> orders= OrderTool.getOrders(eorders);
        OrderStatistics orderStatistics=OrderTool.getPersoanlOrderStatistics(orders);
        orderStatistics.username=username;
        orderStatistics.begin=Timestamp.valueOf(begin);
        orderStatistics.end=Timestamp.valueOf(end);
        return orderStatistics;
    }

    @Override
    public String addEorder(int book_id, String username) {
        try{
            Book book=bookDao.findById(book_id);
            if(book==null)return "Ebook Store Have No This Book!";
        }catch(EntityNotFoundException err){
            return "Ebook Store Have No This Book!";
        }
        try{
            Eorder eorder=eorderDao.getOne(username, book_id, "N");
            if(eorder==null){
                eorderDao.addEorder(book_id, username, TimeTool.now());
                return "Add To Cart";
            }
            if(eorder.getBook().getInventory()>eorder.getBook_num()){
                eorder.setBook_num(eorder.getBook_num()+1);
                eorder.setTime(TimeTool.now());
                jpaRepository.saveAndFlush(eorder);
            }
        }catch(EntityNotFoundException err){
            eorderDao.addEorder(book_id, username, TimeTool.now());
        }catch(Exception err){
            err.printStackTrace();
            return "System Error!";
        }
        return "Add To Cart!";
    }

    @Override
    public String choseEorder(int orderid, String username, String chosen) {
        Eorder eorder=eorderDao.getOneById(orderid, "N");
        if(eorder==null || !eorder.getUsername().equals(username))
            return "Cart Have No This Book!";
        if(!chosen.equals("N"))
            eorder.setChosen(chosen);
        else
            eorder.setChosen("N");
        jpaRepository.saveAndFlush(eorder);
        if(chosen.equals("N"))
            return "Unchose Eorder"+orderid;
        return "Chose Eorder "+orderid;
    }

    @Override
    public int addBookNumber(int orderid, String username, int add) {
        Eorder eorder=eorderDao.getOneById(orderid, "N");
        if(eorder==null || !eorder.getUsername().equals(username))
            return -1;
        int booknum=eorder.getBook_num();
        int inventory=eorder.getBook().getInventory();
        if(booknum+add>inventory){
            eorder.setBook_num(inventory);
            jpaRepository.saveAndFlush(eorder);
            return inventory;
        } else if(eorder.getBook_num()+add<=0){
            eorderDao.deleteById(orderid);
            return 0;
        }else{
            eorder.setBook_num(booknum+add);
            jpaRepository.saveAndFlush(eorder);
            return eorder.getBook_num();
        }
    }

    @Override
    public String choseAllEorder(String username, String chosen) {
        if(!chosen.equals("N"))
            chosen="Y";
        List<Eorder> eorders=eorderDao.getPersonalEorderByPaid(username, "N");
        for(int i=0;i<eorders.size();i++){
            eorders.get(i).setChosen(chosen);
        }
        jpaRepository.saveAll(eorders);
        jpaRepository.flush();
        if(chosen.equals("N"))
            return "Unchose All Eorder!";
        return "Chose All Eorder!";
    }

    @Override
    public String deleteEorderFromCart(String username) {
        eorderDao.deleteEorderByUsername(username, "N", "Y");
        return "Delete Eorder!";
    }

    @Override
    @Transactional
    public float payOrder(String username) {
        List<Eorder> eorders=eorderDao.getPersonalEorderByPaidAndChosen(username, "N", "Y");
        Timestamp time=TimeTool.now();
        float money=0;
        for(int i=0;i<eorders.size();i++){
            Eorder eorder=eorders.get(i);
            eorder.setTime(time);
            eorder.setChosen("N");
            eorder.setPaid("Y");
            money+=eorder.getBook_num()*eorder.getBook().getPrice();
            Book book=eorder.getBook();
            book.setInventory(book.getInventory()-eorder.getBook_num());
            bookJpaRepository.saveAndFlush(book);
        }
        jpaRepository.saveAll(eorders);
        jpaRepository.flush();
        return money;
    }

}
