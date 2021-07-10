package com.graduation.demo.service;

import com.graduation.demo.Dao.*;
import com.graduation.demo.Model.*;
import com.graduation.demo.dto.DoctorReportForCourseAndExam;
import com.graduation.demo.dto.StudentAndExamForCourseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private AssignDepartmentRepository assignDepartmentRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private ExamRepository examRepository;
    @Override
    public Student addStudent(Student student) {
        log.info("Calling ADD_STUDENT service with Object " + student);
        LevelAndDep levelAndDep = new LevelAndDep();
        levelAndDep=student.getLevelAndDep();
        int depart_id=levelAndDep.getDepartment().getId().intValue();
        int level_id=levelAndDep.getLevel().getId().intValue();
        levelAndDep=  assignDepartmentRepository.findByDepartmentAndLevel(depart_id,level_id);

        student.setLevelAndDep(levelAndDep);
        Student existingStudent = repository.save(student);

        Login login =new Login();
        login.setEmail(student.getEmail());
        login.setPassword(student.getPassword());
        login.setType("student");
        login.setUserName(student.getUserName());
        login.setId(existingStudent.getId());
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
            log.info("GET_ALL_STUDENTS RESPONSE" + existingStudents.size());

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
            existingStudent.setEmail(student.getEmail());
            existingStudent.setUserName(student.getUserName());
            existingStudent.setPassword(student.getPassword());

        Login existingLogin=loginRepository.findByUserName(student.getUserName());
        existingLogin.setUserName(student.getUserName());
        existingLogin.setPassword(student.getPassword());
        existingLogin.setEmail(student.getEmail());
        loginRepository.save(existingLogin);
        return repository.save(existingStudent);

    }


    public List<DoctorReportForCourseAndExam> getAllStudentAtCourseId(Long courseId){

        List<DoctorReportForCourseAndExam> reportList= new ArrayList<>();
        List<Student> studentList=repository.getAllStudentAtCourseId(courseId);

        List<Exam> examList=examRepository.getAllExamsForCourse(courseId);
        for (Student student:studentList ) {

            for (Exam exam:examList ) {
                List<Answer> answerList=answerRepository.getAllByStudentAndExamId(student.getId(),exam.getId());
                DoctorReportForCourseAndExam report = new DoctorReportForCourseAndExam();
                if (answerList !=null || answerList.size()>0){
                    Answer answer=answerList.get(0);
                    report.setAnswerDate(answer.getDate().toString());
                    report.setStudentName(student.getName());
                    report.setStudentDegree(answer.getStudentDegree());
                    report.setStudentPhone(student.getPhone());
                    report.setStatus(answer.isPassed());
                    report.setExamDegree(answer.getTotalDegree());
                    report.setExamName(exam.getExam_title());


                }
reportList.add(report);
            }
        }


return reportList;
    }

}
