package com.satwik.e_learningapp.service.serviceImpl;

import com.satwik.e_learningapp.dto.LikedCoursesDto;
import com.satwik.e_learningapp.entity.LikedCourses;
import com.satwik.e_learningapp.repository.LikedCoursesRepo;
import com.satwik.e_learningapp.service.LikedCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LikedCoursesImpl implements LikedCoursesService {
    @Autowired
    private LikedCoursesRepo likedCoursesRepo;
    @Override
    public LikedCoursesDto saveLikedCourses(LikedCoursesDto likedCoursesDto) {
        LikedCourses likedCourses = new LikedCourses();
        likedCourses.setCourseId(likedCoursesDto.getCourseId());
        likedCourses.setPhoneNo(likedCoursesDto.getPhoneNo());
        LikedCourses savedLikedCourse = likedCoursesRepo.save(likedCourses);
        LikedCoursesDto likedCoursesDto1 = new LikedCoursesDto(
                savedLikedCourse.getCourseId(), savedLikedCourse.getPhoneNo()
        );
        return likedCoursesDto1;
    }

    @Override
    public List<String> getAllLikedCourses(String phone_no) {
        List<String> allLikedCourses = new ArrayList<>();
        List<LikedCourses> savedLikedCourses = likedCoursesRepo.getAllByPhoneNo(phone_no);
        for(LikedCourses course : savedLikedCourses){
            allLikedCourses.add(course.getCourseId());
        }
        return allLikedCourses;
    }
    @Override
    public void removeLikedCourse(String courseId, String phoneNo){
        likedCoursesRepo.deleteByCourseIdAndPhoneNo(courseId,phoneNo);
    }
}
