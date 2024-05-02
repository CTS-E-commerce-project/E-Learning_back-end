package com.satwik.e_learningapp.service.serviceImpl;

import com.satwik.e_learningapp.entity.Course;
import com.satwik.e_learningapp.repository.CourseRepo;
import com.satwik.e_learningapp.repository.UserRepo;
import com.satwik.e_learningapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public void deleteCourse(String courseId) {
        courseRepo.deleteById(courseId);
    }

    @Override
    public Course updateCourse(Course course) {
//        Course prevCourse = courseRepo.findById(course.getId()).get();
//        Course updateCourse = new Course();
       Course updatedCourse = courseRepo.save(course);
        return updatedCourse;
    }

}
