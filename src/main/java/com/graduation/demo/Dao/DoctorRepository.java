package com.graduation.demo.Dao;

import com.graduation.demo.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Doctor getDoctorByName(String name);
    Doctor getDoctorByEmail(String email);
}
