package com.zxz.ebook.daoimpl;

import com.zxz.ebook.repository.EorderRespository;
import com.zxz.ebook.dao.EorderDao;
import com.zxz.ebook.entity.Eorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class EorderDaoImpl implements EorderDao {

    @Autowired
    private EorderRespository eorderRespository;

    @Override
    public List<Eorder> findAll() {
        return eorderRespository.findAll();
    }

    @Override
    public List<Eorder> findPersonalEorder(String username, String begin, String end) {
        return eorderRespository.findByUsernameAndTimeBetweenAndPaidIsOrderByTimeDesc(username, begin, end, "Y");
    }

    @Override
    @Transactional
    public void addEorder(int book_id, String user_name, String time) {
        eorderRespository.insertEorder(book_id, user_name, time);
    }

    @Override
    public Eorder getOne(String username, int bookid, String paid) {
        return eorderRespository.getByUsernameAndBookIdAndPaid(username, bookid, paid);
    }

    @Override
    public Eorder getOneById(int id, String paid) {
        return eorderRespository.getByIdAndPaid(id, paid);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        eorderRespository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Eorder> getPersonalEorderByPaid(String username, String paid) {
        return eorderRespository.findByUsernameAndPaid(username, paid);
    }

    @Override
    @Transactional
    public void deleteEorderByUsername(String username, String paid, String chosen){
        eorderRespository.deleteByUsernameAndPaidAndChosen(username, paid, chosen);
    }

    @Override
    public List<Eorder> getPersonalEorderByPaidAndChosen(String username, String paid, String chosen) {
        return eorderRespository.findByUsernameAndPaidAndChosen(username, paid, chosen);
    }

}
