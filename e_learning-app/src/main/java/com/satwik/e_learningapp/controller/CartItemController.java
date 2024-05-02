package com.satwik.e_learningapp.controller;

import com.satwik.e_learningapp.dto.CartItemDto;
import com.satwik.e_learningapp.dto.LikedCoursesDto;
import com.satwik.e_learningapp.service.CartItemService;
import com.satwik.e_learningapp.service.LikedCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/eLearning/v1")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/saveToCart")
    public ResponseEntity<CartItemDto> saveLikedCourse(@RequestBody CartItemDto cartItemDto){
        return new ResponseEntity<>(cartItemService.saveToCart(cartItemDto), HttpStatus.OK);
    }
    @GetMapping("/getAllCartItem/{phoneNo}")
    public ResponseEntity<List<String>> getCartItems(@PathVariable String phoneNo){
        List<String> allLikedCourses = cartItemService.getAllCartItem(phoneNo);
        return ResponseEntity.ok(allLikedCourses);
    }
    @DeleteMapping("/removeCartItem/{courseId}/{phoneNo}")
    public ResponseEntity<String> removeCartItem(@PathVariable String courseId, @PathVariable String phoneNo){
        cartItemService.removeCartItem(courseId,phoneNo);
        return ResponseEntity.ok("Like Removed");
    }
}
