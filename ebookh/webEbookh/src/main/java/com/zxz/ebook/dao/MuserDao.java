package com.zxz.ebook.dao;

import com.zxz.ebook.entity.Muser;

import java.util.List;

public interface MuserDao {
    Muser findByUsername(String username);
    List<Muser> findAll();
}
