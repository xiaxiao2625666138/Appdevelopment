package com.zxz.ebook.serviceimpl;

import com.zxz.ebook.dao.MuserDao;
import com.zxz.ebook.entity.Muser;
import com.zxz.ebook.service.MuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuserServiceImpl implements MuserService {
    @Autowired
    MuserDao muserDao;

    @Override
    public List<Muser> lookAllMuser() {
        return muserDao.findAll();
    }

    @Override
    public Muser lookMuser(String username) {
        return muserDao.findByUsername(username);
    }
}
