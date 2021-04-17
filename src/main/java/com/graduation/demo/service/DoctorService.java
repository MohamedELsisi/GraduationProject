package com.graduation.demo.service;

import com.graduation.demo.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorService extends JpaRepository<Doctor,Long> {
     Doctor getDoctorByName(String name);

}
