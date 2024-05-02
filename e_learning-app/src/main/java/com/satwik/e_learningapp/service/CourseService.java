package com.satwik.e_learningapp.service;

import com.satwik.e_learningapp.entity.Course;
import java.util.List;

public interface CourseService {
    public Course saveCourse(Course course);
    public List<Course> getAllCourses();
    public void deleteCourse(String courseId);
    public Course updateCourse(Course course);
}
