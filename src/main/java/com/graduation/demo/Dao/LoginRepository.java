package com.graduation.demo.Dao;


import com.graduation.demo.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Long> {
Login findByUserName (String userName);

}
