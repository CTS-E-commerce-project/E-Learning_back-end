package com.satwik.e_learningapp.repository;

import com.satwik.e_learningapp.entity.CartItem;
import com.satwik.e_learningapp.entity.LikedCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartItemRepo extends JpaRepository<CartItem,Long> {
    List<CartItem> getAllByPhoneNo(String phoneNo);
    @Transactional
    void deleteByCourseIdAndPhoneNo(String courseId, String phoneNo);
}
