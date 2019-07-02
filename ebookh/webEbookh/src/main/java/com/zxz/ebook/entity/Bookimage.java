package com.zxz.ebook.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="bookimage")
public class Bookimage {
    @Id
    public String id;

    public int bookid;
    public byte[] image;

    public Bookimage() {}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
