package com.graduation.demo.controller;

import com.graduation.demo.Model.Doctor;
import com.graduation.demo.service.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    private DoctorServiceImpl service;

    @PostMapping("/addDoctor")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return service.saveDoctor(doctor);
    }

    @PostMapping("/addAllDoctor")
    public List<Doctor> addAllDoctor(@RequestBody List<Doctor> doctors) {
        return service.saveDoctors(doctors);
    }

    @GetMapping("/findDoctorById/{id}")
    public Doctor findDoctorById(@PathVariable Long id) {
        return service.getDoctorById(id);
    }

    @GetMapping("/getAllDoctors")
    public List<Doctor> getAllDoctors() {
        return service.getAllDoctors();
    }

    @GetMapping("/findDoctorByName/{name}")
    public Doctor findDoctorByName(@PathVariable String name) {
        return service.getDoctorByName(name);
    }

    @DeleteMapping("/deleteDoctor/{id}")
    public String deleteDoctor(Long id) {
        return service.deleteDoctorById(id);
    }
    @PutMapping("/updateDoctor")
    public Doctor updateDoctor(Doctor doctor){
       return service.updateDoctor(doctor);
    }


}
