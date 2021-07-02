package com.graduation.demo.service;

import com.graduation.demo.Dao.LoginRepository;
import com.graduation.demo.Dao.StudentRepository;
import com.graduation.demo.Model.Doctor;
import com.graduation.demo.Model.Login;
import com.graduation.demo.Model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Student addStudent(Student student) {
        log.info("Calling ADD_STUDENT service with Object " + student);
        Student existingStudent = repository.save(student);
        Login login =new Login();
        login.setEmail(student.getEmail());
        login.setPassword(student.getPassword());
        login.setType("student");
        login.setUserName(student.getUserName());
        loginRepository.save(login);


        if (existingStudent == null)
            log.warn("ADD_STUDENT is null");
        else
            log.info("ADD_STUDENT RESPONSE" + existingStudent);
        return existingStudent;
    }

    @Override
    public List<Student> addAllStudents(List<Student> students) {
        log.info("Calling ADD_ALL_STUDENT  service  with object " + students);
        List<Student> existingStudents = repository.saveAll(students);
        if (existingStudents == null)
            log.warn("ADD_ALL_STUDENT IS NULL");
        else
            log.info("ADD_ALL_STUDENT RESPONSE" + existingStudents);
        return existingStudents;
    }

    @Override
    public Student getStudentById(Long id) {
        log.info("Calling GET_STUDENT_BY_ID SERVICE WITH ID " + id);
        Student existingStudent = repository.findById(id).orElse(null);
        if (existingStudent == null)
            log.warn("GET_STUDENT_BY_ID IS NULL");
        else
            log.info("GET_STUDENT_BY_ID RESPONSE " + existingStudent);

        return existingStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        log.info("Calling GET_ALL_STUDENTS SERVICE ");
        List<Student> existingStudents = repository.findAll();
        if (existingStudents == null)
            log.warn("GET_ALL_STUDENTS IS NULL");
        else
            log.info("GET_ALL_STUDENTS RESPONSE" + existingStudents);

        return existingStudents;

    }

    @Override
    public Student getStudentByName(String name) {
        log.info("calling get_Student_By_Name service  " + name);
        Student existingStudent = repository.findByName(name);
        if (existingStudent == null)
            log.warn("get Student By Name is null ");
        else
            log.info("get Student By Name response " + existingStudent);

        return existingStudent;
    }
    @Override
    public Student getStudentByEmail(String email) {
        log.info("calling get_Student_By_email service  " + email);
        Student existingStudent = repository.findByEmail(email);
        if (existingStudent == null)
            log.warn("get Student By Email is null ");
        else
            log.info("get Student By Email response " + existingStudent);

        return existingStudent;
    }




    @Override
    public boolean deleteStudentById(Long id) {
        log.info("calling delete_Student_By_Id service " + id);
        Student existingStudent = repository.findById(id).orElse(null);
        if (existingStudent == null) {
            log.warn("delete Student By Id is null ");
            return false;
        } else {
            log.info("delete Student By Id response ");
            repository.deleteById(id);
            return true;
        }
    }

    @Override
    public Student updateStudent(Student student) {
        log.info("calling  update_Doctor service " + student);
        Student existingStudent = repository.findById(student.getId()).orElse(null);
        if (existingStudent == null)
            log.warn("get Doctor By Name service is null ");
        else
            log.info("update Doctor response ");
            existingStudent.setName(student.getName());
            existingStudent.setPhone(student.getPhone());
            existingStudent.setAddress(student.getAddress());
        repository.save(existingStudent);
        return repository.save(existingStudent);

    }


}
