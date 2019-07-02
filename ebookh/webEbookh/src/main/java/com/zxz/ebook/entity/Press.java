package com.zxz.ebook.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;


@Entity
@Table(name="press", schema="ebookh", catalog="")
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer", "fieldHandler"})
public class Press {

    private int id;
    private String name;

    public Press(){}

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="press_id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name="press_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
