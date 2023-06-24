package com.hung.cozastore.controller;

import com.hung.cozastore.payload.request.SignupRequest;
import com.hung.cozastore.payload.response.BaseResponse;
import com.hung.cozastore.service.imp.UserServiceImp;
import com.hung.cozastore.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserServiceImp userServiceImp;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> signin(@RequestParam String email, @RequestParam String password) {
        UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(email, password);
        authenticationManager.authenticate(user);

        String token = jwtHelper.generateToken(email);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(token);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@Valid SignupRequest request) {
        boolean isSuccess = userServiceImp.addUser(request);

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(isSuccess);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
