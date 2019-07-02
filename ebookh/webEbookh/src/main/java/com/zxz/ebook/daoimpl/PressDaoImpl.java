package com.zxz.ebook.daoimpl;

import com.zxz.ebook.dao.PressDao;
import com.zxz.ebook.entity.Press;
import com.zxz.ebook.repository.PressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PressDaoImpl implements PressDao {

    @Autowired
    PressRepository pressRepository;

    @Override
    public Press saveAndFlush(Press press) {
        return pressRepository.saveAndFlush(press);
    }

    @Override
    public Press getByName(String name) {
        return pressRepository.findByName(name);
    }
}
