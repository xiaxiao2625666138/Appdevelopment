package com.zxz.ebook.repository;

import com.zxz.ebook.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRespository extends JpaRepository<Book, Integer> {
    public List<Book> findByNameContaining(String name);
}
