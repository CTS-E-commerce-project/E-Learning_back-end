package com.satwik.e_learningapp.repository;

import com.satwik.e_learningapp.entity.LikedCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LikedCoursesRepo extends JpaRepository<LikedCourses,Long> {
List<LikedCourses> getAllByPhoneNo(String phoneNo);
    @Transactional
    void deleteByCourseIdAndPhoneNo(String courseId, String phoneNo);
}
