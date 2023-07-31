package com.hung.cozastore.service;

import com.hung.cozastore.entity.UserEntity;
import com.hung.cozastore.exception.customException;
import com.hung.cozastore.payload.request.SignupRequest;
import com.hung.cozastore.repository.UserRepository;
import com.hung.cozastore.service.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean addUser(SignupRequest request) {
        boolean isSuccess = false;
        try {
            UserEntity user = new UserEntity();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());

            userRepository.save(user);
            isSuccess = true;
        } catch (Exception e) {
            throw new customException("Loi them user" + e.getMessage());
        }

        return isSuccess;
    }
}
