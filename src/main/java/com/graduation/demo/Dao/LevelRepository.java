package com.graduation.demo.Dao;

import com.graduation.demo.Model.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level,Long> {
    Level findByName(String name);

}
