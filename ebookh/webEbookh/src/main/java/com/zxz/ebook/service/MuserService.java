package com.zxz.ebook.service;

import com.zxz.ebook.entity.Muser;

import java.util.List;

public interface MuserService {
    List<Muser> lookAllMuser();
    Muser lookMuser(String username);

}
