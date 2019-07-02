package com.zxz.ebook.repository;

import com.zxz.ebook.entity.Bookimage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BookimageRepository extends MongoRepository<Bookimage, String> {
    public Bookimage findByBookid(int bookid);
    public Object deleteByBookid(int bookid);
}
