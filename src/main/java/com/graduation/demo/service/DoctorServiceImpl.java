package com.graduation.demo.service;

import com.graduation.demo.Model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl {
    @Autowired
    private DoctorService doctorService;

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

    public String deleteDoctorById(Long id) {
        doctorService.deleteById(id);
        return "Deleted " + id;
    }

    public Doctor updateDoctor(Doctor doctor) {
        Doctor existingDoctor = doctorService.findById(doctor.getId()).orElse(null);
        existingDoctor.setName(doctor.getName());
        existingDoctor.setPhone(doctor.getPhone());
        existingDoctor.setAddress(doctor.getAddress());

        return doctorService.save(existingDoctor);

    }


}
