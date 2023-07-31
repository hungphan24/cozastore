package com.hung.cozastore.repository;

import com.hung.cozastore.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findByCategoryId(int idCategory);

}
