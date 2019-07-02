package com.zxz.ebook.repository;

import com.zxz.ebook.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WriterRespository extends JpaRepository<Writer, Integer> {
    public List<Writer> findByNameContaining(String name);
    public Writer findByName(String name);
}
