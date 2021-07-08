package com.graduation.demo.service;

import com.graduation.demo.Model.Doctor;

import java.util.List;

public interface DoctorService {

    public Doctor saveDoctor(Doctor doctor);
    public List<Doctor> saveDoctors(List<Doctor> doctors);
    public Doctor getDoctorById(Long id);
    public List<Doctor> getAllDoctors();
    public Doctor getDoctorByName(String name);
    public boolean deleteDoctorById(Long id);
    public Doctor updateDoctor(Doctor doctor);
    Doctor getDoctorByEmail(String email);
}
