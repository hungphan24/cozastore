package com.hung.cozastore.service.imp;

import com.hung.cozastore.payload.request.SignupRequest;

public interface UserServiceImp {

    boolean addUser(SignupRequest request);
}
