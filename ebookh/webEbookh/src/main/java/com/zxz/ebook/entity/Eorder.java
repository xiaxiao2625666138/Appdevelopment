package com.zxz.ebook.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="eorder", schema="ebookh", catalog="")
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer", "fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Eorder {

    private int id;
    private String username;
    private Book book;
    private int book_num;
    private String paid;
    private String time;
    private String chosen;

    public Eorder(){}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="order_id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name="user_name", length=40)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="book_id",referencedColumnName="book_id",nullable=false)
    @JsonIgnoreProperties(value={"id", "publish", "saled","onsale", "score", "score_num", })
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book=book;
    }

    @Basic
    @Column(name="book_num")
    public int getBook_num() {
        return book_num;
    }
    public void setBook_num(int book_num) {
        this.book_num = book_num;
    }

    @Basic
    @Column(name="paid", length=1)
    public String getPaid() {
        return paid;
    }
    public void setPaid(String paid) {
        this.paid = paid;
    }

    @Basic
    @Column(name="time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name="chosen", length=1)
    public String getChosen() {
        return chosen;
    }
    public void setChosen(String chosen) {
        this.chosen = chosen;
    }

}
