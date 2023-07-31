package com.hung.cozastore.service;

import com.hung.cozastore.entity.ProductEntity;
import com.hung.cozastore.payload.response.productResponse;
import com.hung.cozastore.repository.productRepository;
import com.hung.cozastore.service.interf.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class productService implements IProductService {

    @Autowired
    private productRepository repository;

    @Override
    public List<productResponse> getProductByCategory(int id) {
        List<ProductEntity> list = repository.findByCategoryId(id);

        List<productResponse> responseList = new ArrayList<>();
        for(ProductEntity data : list) {
            productResponse response = new productResponse();
            response.setId(data.getId());
            response.setName(data.getName());
            response.setImage(data.getImage());
            response.setPrice(data.getPrice());

            responseList.add(response);
        }
        return responseList;
    }
}
