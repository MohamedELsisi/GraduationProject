package com.graduation.demo.controller;

import com.graduation.demo.Model.Course;
import com.graduation.demo.service.CourseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CourseController {
    @Autowired
    private CourseServiceImpl service;

    @PostMapping("/addCourse")
    public ResponseEntity addCourse(@RequestBody Course course) {
        log.info("ADD_COURSE CONTROLLER " + course);
        Course existingCourse = service.addNewCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(existingCourse);
    }

    @PostMapping("/addAllCourses")
    public ResponseEntity<List<Course>> addAllCourses(@RequestBody List<Course> courses) {
        log.info("ADD ALL COURSES CONTROLLER ");
        List<Course> existingCourses = service.addCourses(courses);
        return ResponseEntity.status(HttpStatus.CREATED).body(existingCourses);
    }

    @GetMapping("/findCourseById/{id}")
    public ResponseEntity findCourseById(@PathVariable Long id) {
        log.info("Find Course by id in controller with id = " + id);
        Course existingCourse = service.findCourseById(id);

        if (existingCourse == null) return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(existingCourse);
    }

    @GetMapping("/getAllCourses")
    public ResponseEntity<List<Course>> getAllCourses() {
        log.info("Get All Courses in controller ");
        List<Course> existingCourses = service.getAllCourses();
        if (existingCourses == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.ok(existingCourses);
    }

    @GetMapping("/findCourseByName/{name}")
    public ResponseEntity findCourseByName(@PathVariable String name) {
        log.info("Find Doctor by Name in Controller with name = " + name);
        Course existingCourse = service.findCourseByName(name);
        if ( existingCourse== null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(existingCourse);
    }
    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity deleteCourse(@PathVariable  Long id) {
        log.info("Delete Course by id in controller with id = " + id);
        boolean status = service.deleteCourseById(id);
        if (status == false)
            return ResponseEntity.notFound().build();

        else
            return ResponseEntity.status(HttpStatus.FOUND).build();
    }

    @PutMapping("/updateCourse")
    public ResponseEntity updateCourse(Course course) {
        log.info("Update  Course controller with object = " + course);
         Course existingCourse = service.updateCourse(course);
        if (existingCourse == null)
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(existingCourse);
        }
    }

}
