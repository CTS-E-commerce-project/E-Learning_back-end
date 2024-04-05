package com.satwik.e_learningapp.repository;

import com.satwik.e_learningapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course,String> {
    List<Course> getAllByPhoneNumber(String phoneNumber);
    @Transactional
    void deleteByIdAndPhoneNumber(String id, String phoneNumber);
//    List<String> findAllDistinctByPhoneNumber();

}
