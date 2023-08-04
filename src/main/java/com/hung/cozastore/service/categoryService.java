package com.hung.cozastore.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hung.cozastore.entity.CategoryEntity;
import com.hung.cozastore.payload.response.categoryResponse;
import com.hung.cozastore.repository.categoryRepository;
import com.hung.cozastore.service.interf.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class categoryService implements ICategory {

    @Autowired
    private categoryRepository repository;

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
   // @Cacheable("listCategory")
    public List<categoryResponse> getAllCategory() {
        List<categoryResponse> responseList = new ArrayList<>();

        if(redisTemplate.hasKey("listCategory")) {
            System.out.println("co du lieu tren redis");
            String data = redisTemplate.opsForValue().get("listCategory").toString();

            Type listType = new TypeToken<ArrayList<categoryResponse>>(){}.getType();
            responseList = new Gson().fromJson(data, listType);
        } else {
            System.out.println("kiem tra category");
            List<CategoryEntity> list = repository.findAll();

            for(CategoryEntity item : list) {
                categoryResponse response = new categoryResponse();
                response.setId(item.getId());
                response.setName(item.getName());

                responseList.add(response);
            }

            Gson gson = new Gson();
            String data = gson.toJson(responseList);
            redisTemplate.opsForValue().set("listCategory", data);


        }



        return responseList;
    }
}
