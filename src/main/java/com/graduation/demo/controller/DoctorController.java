package com.graduation.demo.controller;

import com.graduation.demo.Model.Doctor;
import com.graduation.demo.service.DoctorServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl service;

    @PostMapping("/addDoctor")
    @ApiOperation(value = "insert new doctor ", response = ResponseEntity.class)
    public ResponseEntity createDoctor(@RequestBody Doctor doctor) {
        log.info("create_Doctor_Controller ", doctor);
        Doctor doctor1 = service.saveDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctor1);
    }


    @PostMapping("/addAllDoctor")
    @ApiOperation(value = "insert List of doctor ", response = ResponseEntity.class)
    public ResponseEntity<List<Doctor>> addAllDoctor(@RequestBody List<Doctor> doctors) {
        log.info("create_List_Of_Doctor_Controller " + doctors);
        List<Doctor> doctor1 = service.saveDoctors(doctors);

        return ResponseEntity.ok(doctor1);
    }

    @GetMapping("/findDoctorById/{id}")
    @ApiOperation(value = "search about Doctor by id  ", response = ResponseEntity.class)
    public ResponseEntity findDoctorById(@ApiParam(value = "id value for the doctor u need to retrieve", required = true)
                                         @PathVariable Long id) {
        log.info("Find doctor by id in controller with id = " + id);
        Doctor doctor = service.getDoctorById(id);

        if (doctor == null) return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(doctor);
    }

    @GetMapping("/getAllDoctors")
    @ApiOperation(value = "Show all doctors  ", response = ResponseEntity.class)
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        log.info("Get All Doctors in controller ");
        List<Doctor> existingDoctor = service.getAllDoctors();
        if (existingDoctor == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.ok(existingDoctor);
    }

    @GetMapping("/findDoctorByName/{name}")
    @ApiOperation(value = "Search about Doctor by Name ", response = ResponseEntity.class)
    public ResponseEntity findDoctorByName(@ApiParam(value = "name value for the doctor u need to retrieve", required = true)
                                           @PathVariable String name) {
        log.info("Find Doctor by Name in Controller with name = " + name);
        Doctor doctor = service.getDoctorByName(name);
        if (doctor == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(doctor);
    }

    @DeleteMapping("/deleteDoctor/{id}")
    @ApiOperation(value = "Delete doctor by id",response = ResponseEntity.class)
    public ResponseEntity deleteDoctor(@ApiParam(value = "id value for doctor u need to delete ", required = true)
                                       @PathVariable Long id) {
        log.info("Delete doctor by id in controller with id = " + id);
        boolean status =false;
                service.deleteDoctorById(id);
        if (status == false) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        else return (ResponseEntity) ResponseEntity.ok();
    }

    @PutMapping("/updateDoctor")
    @ApiOperation(value = "Update Doctor data",response = ResponseEntity.class)
    public ResponseEntity updateDoctor(@RequestBody Doctor doctor) {
        log.info("Update  doctor  controller with object = " + doctor);
        Doctor doctor1 = service.updateDoctor(doctor);
        if (doctor1 == null) return ResponseEntity.notFound().build();
        else {
            // logger.info("ORDER_UPDATED_LOG", doctor1.toString());
            return ResponseEntity.ok(doctor1);
        }
    }


}
