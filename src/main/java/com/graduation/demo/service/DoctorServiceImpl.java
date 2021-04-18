package com.graduation.demo.service;

import com.graduation.demo.Dao.DoctorRepository;

import com.graduation.demo.Model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl {
    @Autowired
    private DoctorRepository doctorService;


    public Doctor saveDoctor(Doctor doctor) {
        return doctorService.save(doctor);
    }

    public List<Doctor> saveDoctors(List<Doctor> doctors) {
        return doctorService.saveAll(doctors);
    }

    public Doctor getDoctorById(Long id) {
        return doctorService.findById(id).orElse(null);
    }

    public List<Doctor> getAllDoctors() {
        return doctorService.findAll();
    }

    public Doctor getDoctorByName(String name) {
        return doctorService.getDoctorByName(name);
    }

    public boolean deleteDoctorById(Long id) {
        Doctor doctor =doctorService.findById(id).orElse(null);
        if(doctor.equals(null)) return false;

        else doctorService.deleteById(id);
        return  true;
    }

    public Doctor updateDoctor(Doctor doctor) {
        Doctor existingDoctor = doctorService.findById(doctor.getId()).orElse(null);
        existingDoctor.setName(doctor.getName());
        existingDoctor.setPhone(doctor.getPhone());
        existingDoctor.setAddress(doctor.getAddress());

        return doctorService.save(existingDoctor);

    }


}
