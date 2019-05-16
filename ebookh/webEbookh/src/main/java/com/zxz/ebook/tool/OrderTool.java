package com.zxz.ebook.tool;

import com.zxz.ebook.Business.Order;
import com.zxz.ebook.Business.OrderStatistics;
import com.zxz.ebook.entity.Eorder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class OrderTool {
    public static List<Order> getOrders(List<Eorder> eorders){
        List<Order> orders=new ArrayList<Order>();
        if(eorders.isEmpty())return orders;
        int size= eorders.size();
        Eorder eorder=eorders.get(0);
        Order order=new Order();
        order.time=eorder.getTime();
        order.username=eorder.getUsername();
        order.money=eorder.getBook().getPrice();
        order.booknum=eorder.getBook_num();
        order.eorders.add(eorder);
        for(int i=1;i<size;i++){
            eorder=eorders.get(i);
            if(eorder.getTime().equals(order.time)){
                order.money=order.money+eorder.getBook().getPrice()*eorder.getBook_num();
                order.booknum=order.booknum+eorder.getBook_num();
                order.eorders.add(eorder);
            }else{
                orders.add(order);
                order=new Order();
                order.time=eorder.getTime();
                order.username=eorder.getUsername();
                order.money=eorder.getBook().getPrice()*eorder.getBook_num();
                order.booknum=eorder.getBook_num();
                order.eorders.add(eorder);
            }
        }
        orders.add(order);
        return orders;
    }

    public static OrderStatistics getPersoanlOrderStatistics(List<Order> orders){
        OrderStatistics orderStatistics=new OrderStatistics();
        ListIterator<Order> it=orders.listIterator();
        while(it.hasNext()){
            Order order=it.next();
            orderStatistics.totalMoney+=order.money;
            orderStatistics.totalBooknum+=order.booknum;
            if(orderStatistics.maxMoney<order.money){
                orderStatistics.maxMoney=order.money;
                orderStatistics.maxTime=order.time;
            }
        }
        orderStatistics.orders.addAll(orders);
        orderStatistics.totalTime=orderStatistics.orders.size();
        return orderStatistics;
    }
}
