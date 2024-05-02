package com.satwik.e_learningapp.service;

import com.satwik.e_learningapp.dto.LikedCoursesDto;
import java.util.List;
public interface LikedCoursesService {
    public LikedCoursesDto saveLikedCourses(LikedCoursesDto likedCoursesDto);
    public List<String> getAllLikedCourses(String phone_no);
    public void removeLikedCourse(String courseId, String phoneNo);
}
