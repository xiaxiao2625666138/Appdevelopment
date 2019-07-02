package com.zxz.ebook.repository;

import com.zxz.ebook.entity.Press;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PressRepository extends JpaRepository<Press, Integer> {
    public Press findByName(String name);
}
