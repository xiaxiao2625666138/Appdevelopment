package com.zxz.ebook.daoimpl;

import com.zxz.ebook.dao.EorderDao;
import com.zxz.ebook.entity.Eorder;
import com.zxz.ebook.repository.EorderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public List<Eorder> findPersonalEorder(String username, Timestamp begin, Timestamp end) {
        return eorderRespository.findByUsernameAndTimeBetweenAndPaidIsOrderByTimeDesc(username, begin, end, "Y");
    }
}
