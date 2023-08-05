package com.hung.cozastore.controller;

import com.google.gson.Gson;
import com.hung.cozastore.payload.response.BaseResponse;
import com.hung.cozastore.service.interf.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(productController.class);
    private Gson gson = new Gson();

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getProductByCategory(@PathVariable int id) {
        logger.info("tham so " + id);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(iProductService.getProductByCategory(id));

        logger.info(gson.toJson(response));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
