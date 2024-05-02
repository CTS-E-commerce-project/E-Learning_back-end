package com.satwik.e_learningapp.controller;

import com.satwik.e_learningapp.dto.LikedCoursesDto;
import com.satwik.e_learningapp.service.LikedCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/eLearning/v1")
public class LikedCoursesController {
    @Autowired
    private LikedCoursesService likedCoursesService;

    @PostMapping("/saveLikedCourse")
    public ResponseEntity<LikedCoursesDto> saveLikedCourse(@RequestBody LikedCoursesDto likedCoursesDto){
        return new ResponseEntity<>(likedCoursesService.saveLikedCourses(likedCoursesDto), HttpStatus.OK);
    }
    @GetMapping("/getAllLikedCourses/{phoneNo}")
    public ResponseEntity<List<String>> getLikedCourses(@PathVariable String phoneNo){
        List<String> allLikedCourses = likedCoursesService.getAllLikedCourses(phoneNo);
        return ResponseEntity.ok(allLikedCourses);
    }
    @DeleteMapping("/removeLikedCourse/{courseId}/{phoneNo}")
    public ResponseEntity<String> removeLikedCourse(@PathVariable String courseId, @PathVariable String phoneNo){
        likedCoursesService.removeLikedCourse(courseId,phoneNo);
        return ResponseEntity.ok("Like Removed");
    }
}
