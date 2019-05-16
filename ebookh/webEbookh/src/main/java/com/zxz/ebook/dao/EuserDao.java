package com.zxz.ebook.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zxz.ebook.entity.Euser;

import java.util.List;

public interface EuserDao {
    public List<Euser> findAll();
    public Euser getOne(String username);
    public Euser save(Euser euser);
    public int addEuser(String username, String passwrod, String email);
}
