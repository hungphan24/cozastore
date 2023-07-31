package com.hung.cozastore.service;

import com.hung.cozastore.entity.CategoryEntity;
import com.hung.cozastore.payload.response.categoryResponse;
import com.hung.cozastore.repository.categoryRepository;
import com.hung.cozastore.service.interf.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class categoryService implements ICategory {

    @Autowired
    private categoryRepository repository;
    @Override
    public List<categoryResponse> getAllCategory() {
        List<CategoryEntity> list = repository.findAll();
        List<categoryResponse> responseList = new ArrayList<>();
        for(CategoryEntity item : list) {
            categoryResponse response = new categoryResponse();
            response.setId(item.getId());
            response.setName(item.getName());

            responseList.add(response);
        }

        return responseList;
    }
}
