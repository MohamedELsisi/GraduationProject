package com.graduation.demo.controller;

import com.graduation.demo.Model.Doctor;
import com.graduation.demo.dto.doctorDto;
import com.graduation.demo.service.DoctorServiceImpl;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.flogger.Flogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {
    private static final Logger logger =
            (Logger) LoggerFactory.getLogger(DoctorController.class);
    @Autowired
    private DoctorServiceImpl service;

    @PostMapping("/addDoctor")
    public ResponseEntity createDoctor(@RequestBody Doctor doctor) {
        Doctor doctor1 = service.saveDoctor(doctor);
        logger.info("NEW_Doctor_LOG", doctor1.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(doctor1);
    }


    @PostMapping("/addAllDoctor")
    public ResponseEntity<List<Doctor>> addAllDoctor(@RequestBody List<Doctor> doctors) {
         List<Doctor> doctor1 =service.saveDoctors(doctors);
         return ResponseEntity.ok(doctor1);
    }

    @GetMapping("/findDoctorById/{id}")
    public ResponseEntity findDoctorById(@PathVariable Long id) {
        Doctor doctor = service.getDoctorById(id);
        if (doctor.equals(null)) return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(doctor);
    }

    @GetMapping("/getAllDoctors")
    public List<Doctor> getAllDoctors() {
        return service.getAllDoctors();
    }

    @GetMapping("/findDoctorByName/{name}")
    public ResponseEntity findDoctorByName(@PathVariable String name) {
        Doctor doctor = service.getDoctorByName(name);
        if (doctor.equals(null)) return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(doctor);
    }

    @DeleteMapping("/deleteDoctor/{id}")
    public ResponseEntity deleteDoctor(Long id) {
        boolean status = service.deleteDoctorById(id);
        if (status == false) return ResponseEntity.notFound().build();

        else return ResponseEntity.status(HttpStatus.FOUND).build();
    }

    @PutMapping("/updateDoctor")
    public ResponseEntity updateDoctor(Doctor doctor) {
        Doctor doctor1 = service.updateDoctor(doctor);
        if (doctor1.equals(null)) return ResponseEntity.notFound().build();
        else {
            logger.info("ORDER_UPDATED_LOG", doctor1.toString());
            return ResponseEntity.ok(doctor1);
        }
    }


}
