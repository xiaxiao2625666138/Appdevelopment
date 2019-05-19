package com.zxz.ebook.serviceimpl;

import com.zxz.ebook.Business.Order;
import com.zxz.ebook.dao.EuserDao;
import com.zxz.ebook.entity.Eorder;
import com.zxz.ebook.entity.Euser;
import com.zxz.ebook.service.EuserService;
import com.zxz.ebook.tool.OrderTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class EuserServiceImpl implements EuserService {

    @Autowired
    private EuserDao euserDao;

    /*
    @Override
    public List<Euser> lookAllEuser() {
        return euserDao.findAll();
    }

    @Override
    public Euser getOneEuser(String username) {
        return euserDao.getOne(username);
    }
    */

    @Override
    public String loginEuser(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        HttpSession session = ((HttpServletRequest)request).getSession(true);
        try{
            Euser euser=euserDao.getOne(username);
            if(euser.getPassword().equals(password)){
                session.setAttribute("username", username);
                if(euser.getName().equals("administrator"))
                    session.setAttribute("islogin", 2);
                else
                    session.setAttribute("islogin", 1);
                return username;
            }
            return "Check Password, Please!";
        }catch(EntityNotFoundException err){
            return "Check Username, Please!";
        }
    }

    @Override
    public String registerEuser(String username, String password, String confirmPassword, String email) {
        if(username.length()==0)return "Check Username!";
        if(password.length()==0)return "Check Password!";
        if(!password.equals(confirmPassword))return "Different Password!";
        if(!email.matches("\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}"))return "Check Email!";
        try{
            Euser euser=euserDao.getOne(username);
            euser.getPassword().equals(password);
            return "Username Have Been Register!";
        }catch(EntityNotFoundException err){
            if(euserDao.addEuser(username, password, email)==1) return "Register Successfully!";
            return "System Error!";
        }
    }

    private List<Eorder> getPersonalEorder(String username, String paid) {
        List<Eorder> eorders= euserDao.getOne(username).getOrders();
        for(int i=0;i<eorders.size();i++){
            if(!eorders.get(i).getPaid().equals(paid)){
                eorders.remove(i);
                i--;
            }
        }
        return eorders;
    }

    @Override
    public String logout(HttpServletRequest request) {
        HttpSession session=request.getSession();
        try{
            session.setAttribute("islogin", 0);
            return "Logout Successfully!";
        }catch(NullPointerException err){
            return "Logout Successfully!";
        }
    }

    @Override
    public int userType(HttpServletRequest request) {
        HttpSession session=request.getSession();
        return (int)session.getAttribute("islogin");
    }

    @Override
    public List<Order> getOrders(String username) {
        List<Eorder> eorders=this.getPersonalEorder(username, "Y");
        return OrderTool.getOrders(eorders);
    }

    @Override
    public List<Eorder> getCart(String username) {
        return this.getPersonalEorder(username, "N");
    }
}
