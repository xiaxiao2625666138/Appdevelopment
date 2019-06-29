package com.zxz.ebook.repository;

import java.util.List;

import com.zxz.ebook.entity.Muser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MuserRepository extends MongoRepository<Muser, String> {
    @Query("{ 'username' : ?0 }")
    public Muser findByUsername(String username);

    @Query("{ 'nickname' : ?0 }")
    public List<Muser> findByNickname(String nickname);
}