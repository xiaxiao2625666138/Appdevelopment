package com.zxz.ebook.repository;

import com.zxz.ebook.entity.Eorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface EorderRespository extends JpaRepository<Eorder, Integer> {
    List<Eorder> findByUsernameAndTimeBetweenAndPaidIsOrderByTimeDesc(String username, Timestamp begin, Timestamp end, String paid);
}
