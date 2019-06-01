package com.zxz.ebook.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="writer", schema="ebookh", catalog="")
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer", "fieldHandler"})
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)*/
public class Writer {

    private int id;
    private String name;
    /*
    private String introduce;
    */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="writer_id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name="writer_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private List<Book> books;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy="authors")
    @JsonIgnoreProperties(value={"authors"})
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
