package com.graduation.demo.controller;

import com.graduation.demo.Model.Doctor;
import com.graduation.demo.dto.doctorDto;
import com.graduation.demo.service.DoctorServiceImpl;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DoctorController {

    @Autowired
    private DoctorServiceImpl service;

    @PostMapping("/addDoctor")
    public ResponseEntity createDoctor(@RequestBody Doctor doctor) {
        log.info("create_Doctor_Controller ", doctor);
        Doctor doctor1 = service.saveDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctor1);
    }


    @PostMapping("/addAllDoctor")
    public ResponseEntity<List<Doctor>> addAllDoctor(@RequestBody List<Doctor> doctors) {
        log.info("create_List_Of_Doctor_Controller "+ doctors);
        List<Doctor> doctor1 = service.saveDoctors(doctors);

        return ResponseEntity.ok(doctor1);
    }

    @GetMapping("/findDoctorById/{id}")
    public ResponseEntity findDoctorById(@PathVariable Long id) {
        log.info("Find doctor by id in controller with id = " + id);
        Doctor doctor = service.getDoctorById(id);

        if (doctor == null) return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(doctor);
    }

    @GetMapping("/getAllDoctors")
    public List<Doctor> getAllDoctors() {
        log.info("Get All Doctors in controller ");
        return service.getAllDoctors();
    }

    @GetMapping("/findDoctorByName/{name}")
    public ResponseEntity findDoctorByName(@PathVariable String name) {
        log.info("Find Doctor by Name in Controller with name = " + name);
        Doctor doctor = service.getDoctorByName(name);
        if (doctor == null) return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(doctor);
    }

    @DeleteMapping("/deleteDoctor/{id}")
    public ResponseEntity deleteDoctor(Long id) {
        log.info("Delete doctor by id in controller with id = " + id);
        boolean status = service.deleteDoctorById(id);
        if (status == false) return ResponseEntity.notFound().build();

        else return ResponseEntity.status(HttpStatus.FOUND).build();
    }

    @PutMapping("/updateDoctor")
    public ResponseEntity updateDoctor(Doctor doctor) {
        log.info("Update  doctor  controller with object = " + doctor);
        Doctor doctor1 = service.updateDoctor(doctor);
        if (doctor1 == null) return ResponseEntity.notFound().build();
        else {
            // logger.info("ORDER_UPDATED_LOG", doctor1.toString());
            return ResponseEntity.ok(doctor1);
        }
    }


}
