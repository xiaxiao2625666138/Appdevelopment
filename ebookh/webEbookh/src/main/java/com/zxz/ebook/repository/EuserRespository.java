package com.zxz.ebook.repository;

import com.zxz.ebook.entity.Euser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EuserRespository extends JpaRepository<Euser, String>{
    @Modifying
    @Query(value="insert euser(user_name, user_password, email) values(?1, ?2, ?3)", nativeQuery = true)
    void insertEuser(String username, String passwrod, String email);
}
