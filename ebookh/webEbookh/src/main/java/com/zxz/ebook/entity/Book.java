package com.zxz.ebook.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zxz.ebook.tool.PriceFormat;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="book", schema="ebookh", catalog="")
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer", "fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Book {
    private int id;
    private String name;
    private String subtitle;
    private int version;
    private String language;
    private String cover;
    private float price;
    private int inventory;
    private int saled;
    private float score;
    private int score_num;
    private  String onsale;
    private String ISBN;

    public Book(){}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="book_id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name="book_name", length=50)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name="subtitle", length=50)
    public String getSubtitle() {
        return subtitle;
    }
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @Basic
    @Column(name="version")
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Basic
    @Column(name="language", length=30)
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name="cover", length=200)
    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }

    @Basic
    @Column(name="price")
    @JsonSerialize(using = PriceFormat.class)
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    @Basic
    @Column(name="inventory")
    public int getInventory() {
        return inventory;
    }
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Basic
    @Column(name="saled")
    public int getSaled() {
        return saled;
    }
    public void setSaled(int saled) {
        this.saled = saled;
    }

    @Basic
    @Column(name="score")
    public float getScore() {
        return score;
    }
    public void setScore(float score) {
        this.score = score;
    }

    @Basic
    @Column(name="score_num")
    public int getScore_num() {
        return score_num;
    }
    public void setScore_num(int score_num) {
        this.score_num = score_num;
    }

    @Basic
    @Column(name="onsale")
    public String getOnsale() {
        return onsale;
    }
    public void setOnsale(String onsale) {
        this.onsale = onsale;
    }

    @Basic
    @Column(name="ISBN")
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }


    private List<Writer> authors;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="hasauthor", joinColumns=@JoinColumn(name="book_id"),
        inverseJoinColumns = @JoinColumn(name="writer_id"))
    @JsonIgnoreProperties(value={"books","id"})
    public List<Writer> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Writer> authors) {
        this.authors = authors;
    }
/*
    private String publish;
    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="press", joinColumns = {
            @JoinColumn(name="publish", referencedColumnName = "press_id")})
    @Column(name="press_name")
    public String getPublish() {
        return publish;
    }
    public void setPublish(String publish) {
        this.publish = publish;
    }
*/
}
