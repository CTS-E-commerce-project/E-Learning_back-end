package com.satwik.e_learningapp.service;

public interface EmailService {

    void sendVerificationEmail(String to,String token);

}
