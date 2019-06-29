package com.zxz.ebook.daoimpl;

import com.zxz.ebook.dao.MuserDao;
import com.zxz.ebook.entity.Muser;
import com.zxz.ebook.repository.MuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MuserDaoImpl implements MuserDao {

    @Autowired
    MuserRepository muserRepository;

    @Override
    public Muser findByUsername(String username) {
        return muserRepository.findByUsername(username);
    }

    @Override
    public List<Muser> findAll() {

        return muserRepository.findAll();
    }
}
