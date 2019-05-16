package com.zxz.ebook.daoimpl;

import com.zxz.ebook.dao.WriterDao;
import com.zxz.ebook.entity.Writer;
import com.zxz.ebook.repository.WriterRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WriterDaoImpl implements WriterDao {

    @Autowired
    private WriterRespository writerRespository;

    @Override
    public List<Writer> findAll() {
        return writerRespository.findAll();
    }

    @Override
    public List<Writer> findByNameContaining(String name) {
        return writerRespository.findByNameContaining(name);
    }
}
