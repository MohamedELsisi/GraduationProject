package com.graduation.demo.service;

import com.graduation.demo.Dao.CourseRepository;
import com.graduation.demo.Model.Course;
import com.graduation.demo.dto.ALlCoursesReportByStudent;
import com.graduation.demo.dto.StudentAnswerForCourseDTO;
import com.graduation.demo.dto.StudentAnswerForCourseTableDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AnswerServiceImpl answerService;

    @Override
    public Course addNewCourse(Course course) {
        log.info("Calling ADD_NEW_COURSE service with object " + course);
        Course existingCourse = courseRepository.save(course);
        if (existingCourse == null)
            log.warn("ADD_NEW_COURSE is null");
        else
            log.info("ADD_NEW_COURSE response " + existingCourse);
        return existingCourse;
    }

    @Override
    public List<Course> addCourses(List<Course> courses) {
        log.info("Calling ADD_COURSES Service with List ");
        List<Course> existingCourse = courseRepository.saveAll(courses);
        if (existingCourse == null)
            log.warn("ADD_COURSES is null");
        else
            log.info("ADD_COURSES response " + existingCourse);
        return existingCourse;
    }

    @Override
    public Course findCourseById(Long id) {
        log.info("Calling FIND_COURSE_BY_ID Service with id " + id);
        Course existingCourse = courseRepository.findById(id).orElse(null);
        if (existingCourse == null)
            log.warn("FIND_COURSE_BY_ID IS NULL");
        else
            log.info("FIND_COURSE_BY_ID RESPONSE " + existingCourse);

        return existingCourse;
    }

    @Override
    public List<Course> getAllCourses() {
        log.info("CALLING GET_ALL_COURSES SERVICE ");
        List<Course> existingCourse = courseRepository.findAll();
        if (existingCourse == null)
            log.warn("GET_ALL_COURSES IS NULL");
        else
            log.info("GET_ALL_COURSES RESPONSE" + existingCourse.size());

        return existingCourse;
    }

    @Override
    public Course findCourseByName(String name) {
        log.info("CALLING FIND_COURSE_BY_NAME SERVICE WITH STRING  " + name);
        Course existingCourse = courseRepository.findByName(name);
        if (existingCourse == null)
            log.warn("FIND_COURSE_BY_NAME IS NULL");
        else
            log.info("FIND_COURSE_BY_NAME RESPONSE " + existingCourse);
        return existingCourse;
    }

    @Override
    public boolean deleteCourseById(Long id) {
        log.info("CALLING DELETE_COURSE_BY_ID SERVICE WITH ID  "+id);
        Course existingCourse =courseRepository.findById(id).orElse(null);
        if(existingCourse==null)
        {
            log.warn("DELETE_COURSE_BY_ID IS NULL");
            return false;

        } else
            {
                log.info("DELETE_COURSE_BY_ID RESPONSE"+existingCourse);
                courseRepository.deleteById(id);
                return true;
            }

    }

    @Override
    public Course updateCourse(Course course) {
        log.info("CALLING UPDATE_COURSE SERVICE WITH OBJECT  "+course );
        Course existingCourse =courseRepository.findById(course.getId()).orElse(null);
        if(existingCourse==null)
            log.warn("UPDATE_COURSE Is NULL");
        else
        {
            existingCourse.setName(course.getName());
            existingCourse.setLevel_id(course.getLevel_id());
            courseRepository.save(existingCourse);
            log.info("UPDATE_COURSE RESPONSE"+existingCourse);

        }

        return existingCourse;
    }


    public List<Course> findCourseByDoctorId(int id) {
        log.info("Calling FIND_COURSE_BY_ID Service with id " + id);
        List<Course> existingCourse = courseRepository.findByDoctorId(id);
        if (existingCourse == null)
            log.warn("FIND_COURSE_BY_ID IS NULL");

        return existingCourse;
    }

    public List<Course> findAllCoursesByStudentId(int studentId){

        log.info("Calling findAllCoursesByStudentId " + studentId);
        List<Course> existingCourse = courseRepository.findAllCoursesByStudentId(studentId);


        return existingCourse;
    }

    public ALlCoursesReportByStudent findCoursesReportByStudentId(int studentId){

String colorArray[]={"#82b741","#afafaf","#c0a2fa","#a2fac0","#14A9A4","#a9a414","#F27DBA","#028c6a","#FF5733","#DFE509"};
         List<String> coursesName = new ArrayList<>();
         List<Integer> degree= new ArrayList<>();
         List<String> colors= new ArrayList<>();
        ALlCoursesReportByStudent reportByStudent = new ALlCoursesReportByStudent();
        log.info("Calling findAllCoursesByStudentId " + studentId);
        List<Course> existingCourse = courseRepository.findAllCoursesByStudentId(studentId);

        int index=0;
        for (Course course:existingCourse ) {
            StudentAnswerForCourseDTO courseDTO = answerService.getAllByStudentAndCourseId(new Long(studentId), course.getId());
            if (courseDTO != null) {
                coursesName.add(course.getName());
                colors.add(colorArray[index++]);

                int summationStudentDegree = 0;
                for (StudentAnswerForCourseTableDTO forCourseTableDTO : courseDTO.getCourseTableDTO()) {

                    summationStudentDegree += forCourseTableDTO.getStudentDegree();
                }

                degree.add(summationStudentDegree);

            }
        }

        reportByStudent.setCoursesName(coursesName);
        reportByStudent.setColors(colors);
        reportByStudent.setDegree(degree);
        return reportByStudent;
    }
}
