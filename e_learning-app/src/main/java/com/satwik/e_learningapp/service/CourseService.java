package com.satwik.e_learningapp.service;

import com.satwik.e_learningapp.entity.Course;
import java.util.List;

public interface CourseService {
    public Course saveCourse(Course course);
    public List<Course> getAllCourseByPhoneNumber(String phoneNumber);

    public void deleteCourseByCourseIdAndPhoneNumber(String courseId, String phoneNumber);


}
