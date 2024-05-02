package com.satwik.e_learningapp.service.serviceImpl;

import com.satwik.e_learningapp.dto.CartItemDto;
import com.satwik.e_learningapp.entity.CartItem;
import com.satwik.e_learningapp.repository.CartItemRepo;
import com.satwik.e_learningapp.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemImpl implements CartItemService {
    @Autowired
    private CartItemRepo cartItemRepo;
    @Override
    public CartItemDto saveToCart(CartItemDto cartItemDto) {
        CartItem cartItem = new CartItem();
        cartItem.setCourseId(cartItemDto.getCourseId());
        cartItem.setPhoneNo(cartItemDto.getPhoneNo());
        CartItem cartItem1 = cartItemRepo.save(cartItem);
        CartItemDto cartItem2 = new CartItemDto(
                cartItem1.getCourseId(), cartItem1.getPhoneNo()
        );
        return cartItem2;
    }

    @Override
    public List<String> getAllCartItem(String phone_no) {
        List<String> allCartItem = new ArrayList<>();
        List<CartItem> allCartItems = cartItemRepo.getAllByPhoneNo(phone_no);
        for(CartItem item : allCartItems){
            allCartItem.add(item.getCourseId());
        }
        return allCartItem;
    }
    @Override
    public void removeCartItem(String courseId, String phoneNo){
        cartItemRepo.deleteByCourseIdAndPhoneNo(courseId,phoneNo);
    }
}
