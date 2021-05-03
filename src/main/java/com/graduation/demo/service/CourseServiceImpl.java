package com.graduation.demo.service;

import com.graduation.demo.Dao.CourseRepository;
import com.graduation.demo.Model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

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
            log.info("GET_ALL_COURSES RESPONSE" + existingCourse);

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
            existingCourse.setGrade(course.getGrade());
            existingCourse.setPassed_value(course.getPassed_value());
            courseRepository.save(existingCourse);
            log.info("UPDATE_COURSE RESPONSE"+existingCourse);

        }

        return existingCourse;
    }
}