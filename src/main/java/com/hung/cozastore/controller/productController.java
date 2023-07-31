package com.hung.cozastore.controller;

import com.hung.cozastore.payload.response.BaseResponse;
import com.hung.cozastore.service.interf.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class productController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getProductByCategory(@PathVariable int id) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(iProductService.getProductByCategory(id));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
