package com.zxz.ebook.daoimpl;

import com.zxz.ebook.repository.EuserRespository;
import com.zxz.ebook.dao.EuserDao;
import com.zxz.ebook.entity.Euser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EuserDaoImpl implements EuserDao {

    @Autowired
    private EuserRespository euserRepository;

    @Override
    public List<Euser> findAll() {
        return euserRepository.findAll();
    }

    @Override
    public Euser getOne(String username) {
        return euserRepository.getOne(username);
    }

    @Override
    @Transactional
    public int addEuser(String username, String password, String email) {
        try{
            euserRepository.insertEuser(username, password, email);
            euserRepository.flush();
            return 1;
        }catch(Exception err){
            err.printStackTrace();
            return 0;
        }
    }

}
