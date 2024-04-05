package com.satwik.e_learningapp.repository;

import com.satwik.e_learningapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
//    public List<User> findAllByPhone
}
