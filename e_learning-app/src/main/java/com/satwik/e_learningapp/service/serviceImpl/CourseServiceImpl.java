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
    public List<Course> getAllCourseByPhoneNumber(String phoneNumber) {
        return courseRepo.getAllByPhoneNumber(phoneNumber);
    }

    @Override
    public void deleteCourseByCourseIdAndPhoneNumber(String courseId, String phoneNumber) {
        courseRepo.deleteByIdAndPhoneNumber(courseId,phoneNumber);
    }

}
