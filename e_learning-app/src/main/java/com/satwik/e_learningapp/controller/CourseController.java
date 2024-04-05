package com.satwik.e_learningapp.controller;

import com.satwik.e_learningapp.entity.Course;
import com.satwik.e_learningapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/eLearning/v1")
public class CourseController {
    @Autowired
    CourseService courseService;
    @PostMapping("/saveCourse")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.OK);
    }
    @GetMapping("/getAllCourse/{id}")
    public ResponseEntity<List<Course>> getAllCourseByPhoneNumber(@PathVariable String id){
        List<Course> courses = courseService.getAllCourseByPhoneNumber(id);
        return ResponseEntity.ok(courses);
    }
}
