package com.hung.cozastore.service.interf;

import com.hung.cozastore.payload.request.SignupRequest;

public interface IUserService {

    boolean addUser(SignupRequest request);
}
