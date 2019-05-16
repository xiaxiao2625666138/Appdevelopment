package com.zxz.ebook.serviceimpl;

import com.zxz.ebook.Business.Order;
import com.zxz.ebook.Business.OrderStatistics;
import com.zxz.ebook.dao.EorderDao;
import com.zxz.ebook.entity.Eorder;
import com.zxz.ebook.service.EorderService;
import com.zxz.ebook.tool.OrderTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class EorderServiceImpl implements EorderService {

    @Autowired
    private EorderDao eorderDao;

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


}
