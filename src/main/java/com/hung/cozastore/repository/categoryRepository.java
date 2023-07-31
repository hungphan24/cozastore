package com.hung.cozastore.repository;

import com.hung.cozastore.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepository extends JpaRepository<CategoryEntity, Integer> {

}
