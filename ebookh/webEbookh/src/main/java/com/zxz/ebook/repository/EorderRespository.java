package com.zxz.ebook.repository;

import com.zxz.ebook.entity.Eorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Convert;
import java.sql.Timestamp;
import java.util.List;

public interface EorderRespository extends JpaRepository<Eorder, Integer> {
    List<Eorder> findByUsernameAndTimeBetweenAndPaidIsOrderByTimeDesc(String username, String begin, String end, String paid);

    @Modifying
    @Query(value="insert eorder(book_id, user_name, time) values(?1, ?2, ?3)", nativeQuery = true)
    void insertEorder(int book_id, String user_name, String time);

    Eorder getByUsernameAndBookIdAndPaid(String username, int bookid, String paid);

    Eorder getByIdAndPaid(int id, String paid);

    void deleteById(int id);

    List<Eorder> findByUsernameAndPaid(String username, String paid);

    void deleteByUsernameAndPaidAndChosen(String username, String paid, String chosen);

    List<Eorder> findByUsernameAndPaidAndChosen(String username, String paid, String chosen);

    List<Eorder> findByPaidOrderByTimeDesc(String paid);

    @Query(value="select user_name as username," +
            " sum(book_num) as booknum, sum(book_num*price) as consumption" +
            " from eorder natural join book where time between ?1 and ?2 and paid='Y' group by user_name", nativeQuery = true)
    List<Object> userConsume(String begin, String end);

    @Query(value="select book_id as id, " +
            "ISBN as isbn, book_name as name, count(time) as personTime," +
            " sum(book_num) as saled from eorder natural join book where time between ?1 and ?2 and paid='Y' group by book_id, book_name, saled, ISBN",
            nativeQuery = true)
    @Convert
    List<Object> bookSaled(String begin, String end);
}
