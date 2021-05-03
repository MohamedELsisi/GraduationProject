package com.graduation.demo.Dao;

import com.graduation.demo.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository <Question,Long> {

}
