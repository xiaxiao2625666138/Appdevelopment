package com.zxz.ebook.dao;

import com.zxz.ebook.entity.Euser;

import java.util.List;

public interface EuserDao {
    public List<Euser> findAll();
    public Euser getOne(String username);
    public int addEuser(String username, String passwrod, String email);
}
