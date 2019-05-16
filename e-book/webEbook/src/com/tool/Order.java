package com.tool;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Order {
    static public void printOrder(ResultSet rs, JSONArray jsonArr) throws SQLException, JSONException {
        if(rs.next()) {
            float money = rs.getFloat("price")*rs.getInt("book_num");
            String time=rs.getString("time");
            JSONObject oneOrder = new JSONObject();
            oneOrder.put("user_name", rs.getString("user_name"));
            oneOrder.put("time", time);
            JSONArray OrderBooks=new JSONArray();
            addOrderBook(rs, OrderBooks);
            while(rs.next()){
                if(time.equals(rs.getString("time"))){
                    money=money+rs.getFloat("price")*rs.getInt("book_num");
                    addOrderBook(rs, OrderBooks);
                }else {
                    oneOrder.put("money", new java.text.DecimalFormat("#.0").format(money));
                    oneOrder.put("books", OrderBooks);
                    jsonArr.put(oneOrder);
                    money = rs.getFloat("price")*rs.getInt("book_num");
                    time=rs.getString("time");
                    oneOrder=new JSONObject();
                    oneOrder.put("user_name", rs.getString("user_name"));
                    oneOrder.put("time", time);
                    OrderBooks=new JSONArray();
                    addOrderBook(rs, OrderBooks);
                }
            }
            oneOrder.put("money",  new java.text.DecimalFormat("#.0").format(money));
            oneOrder.put("books", OrderBooks);
            jsonArr.put(oneOrder);
        }
    }
    static private void addOrderBook(ResultSet rs, JSONArray jsonArr) throws SQLException, JSONException {
        JSONObject jsonObj=new JSONObject();
        jsonObj.put("order_id", rs.getString("order_id"));
        jsonObj.put("book_name", rs.getString("book_name"));
        jsonObj.put("book_num", rs.getString("book_num"));
        jsonObj.put("subtitle", rs.getString("subtitle"));
        jsonObj.put("language_name", rs.getString("language_name"));
        jsonObj.put("version", rs.getInt("version"));
        jsonObj.put("price",  new java.text.DecimalFormat("#.0").format(rs.getFloat("price")));
        jsonObj.put("ISBN", rs.getString("ISBN"));
        jsonObj.put("cover", rs.getString("cover"));
        jsonArr.put(jsonObj);
    }
    static public void printOrderStatistics(ResultSet rs, JSONObject jsonObj) throws SQLException, JSONException {
        float totalMoney=0;
        int totalBookNum=0;
        JSONArray jsonArr=new JSONArray();
        String maxTime="";
        float maxMoney=0;
        while(rs.next()){
            JSONObject singleOrder=new JSONObject();
            singleOrder.put("time", rs.getString("time"));
            singleOrder.put("book_num", rs.getInt("book_number"));
            float money=rs.getFloat("money");
            singleOrder.put("money", new java.text.DecimalFormat("#.0").format(money));
            jsonArr.put(singleOrder);
            totalBookNum=totalBookNum+rs.getInt("book_number");
            totalMoney=totalMoney+money;
            if(money>maxMoney){
                maxTime=rs.getString("time");
                maxMoney=money;
            }
        }
        jsonObj.put("orders", jsonArr);
        jsonObj.put("times", jsonArr.length());
        jsonObj.put("TotalMoney", new java.text.DecimalFormat("#.0").format(totalMoney));
        jsonObj.put("book_num", totalBookNum);
        jsonObj.put("maxTime", maxTime);
        jsonObj.put("maxMoney", new java.text.DecimalFormat("#.0").format(maxMoney));
    }
}
