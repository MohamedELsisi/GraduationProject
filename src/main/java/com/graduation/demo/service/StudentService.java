package com.graduation.demo.service;

import com.graduation.demo.Model.Doctor;
import com.graduation.demo.Model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    List<Student> addAllStudents(List<Student> students);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    Student getStudentByName(String name);
    boolean deleteStudentById(Long id);
    Student updateStudent(Student student);

    Student getStudentByEmail(String email);
}
