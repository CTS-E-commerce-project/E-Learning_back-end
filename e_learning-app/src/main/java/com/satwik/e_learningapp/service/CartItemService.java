package com.satwik.e_learningapp.service;

import com.satwik.e_learningapp.dto.CartItemDto;
import com.satwik.e_learningapp.dto.LikedCoursesDto;

import java.util.List;

public interface CartItemService {
    public CartItemDto saveToCart(CartItemDto cartItemDto);
    public List<String> getAllCartItem(String phoneNo);
    public void removeCartItem(String courseId, String phoneNo);
}
