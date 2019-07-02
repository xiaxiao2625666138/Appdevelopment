package com.zxz.ebook.repository;

import com.zxz.ebook.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRespository extends JpaRepository<Book, Integer> {
    public List<Book> findByNameContaining(String name);
    public Book deleteById(int id);
}
