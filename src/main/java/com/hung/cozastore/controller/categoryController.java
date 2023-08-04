package com.hung.cozastore.controller;

import com.hung.cozastore.payload.response.BaseResponse;
import com.hung.cozastore.payload.response.categoryResponse;
import com.hung.cozastore.service.interf.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class categoryController {
    @Autowired
    private ICategory iCategory;

    @GetMapping("/clear-cache")
    @CacheEvict(value = "listCategory", allEntries = true)
    public ResponseEntity<?> clearCache() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCategory() {
        BaseResponse response = new BaseResponse();
        response.setData(iCategory.getAllCategory());
        response.setStatusCode(200);
        response.setMessage("oke");


        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
