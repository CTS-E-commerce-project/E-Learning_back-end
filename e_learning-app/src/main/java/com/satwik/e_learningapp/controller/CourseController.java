package com.satwik.e_learningapp.controller;

import com.satwik.e_learningapp.entity.Course;
import com.satwik.e_learningapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/eLearning/v1")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping("/saveCourse")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.OK);
    }
    @GetMapping("/getAllCourses")
    public ResponseEntity<List<Course>> getAllCourses(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }
    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted");
    }
    @PutMapping("/updateCourse")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        return ResponseEntity.ok(courseService.updateCourse(course));
    }

}
