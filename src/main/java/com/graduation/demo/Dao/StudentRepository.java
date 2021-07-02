package com.graduation.demo.Dao;

import com.graduation.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
   Student findByName(String name);
   Student findByEmail(String email);
}
