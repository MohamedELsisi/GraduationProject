package com.graduation.demo.service;

import com.graduation.demo.Model.Course;

import java.util.List;

public interface CourseService {
    public Course addNewCourse(Course course);
    public List<Course> addCourses(List<Course>courses );
    public Course findCourseById(Long id);
    public List<Course> getAllCourses ();
    public Course findCourseByName(String name);
    public boolean deleteCourseById(Long id);
    public Course updateCourse (Course  course);
}
