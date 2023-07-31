package com.hung.cozastore.service.interf;

import com.hung.cozastore.payload.response.productResponse;

import java.util.List;

public interface IProductService {
    List<productResponse> getProductByCategory(int id);
}
