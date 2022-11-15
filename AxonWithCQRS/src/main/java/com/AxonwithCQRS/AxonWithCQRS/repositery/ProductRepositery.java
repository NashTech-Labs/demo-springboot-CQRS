package com.AxonwithCQRS.AxonWithCQRS.repositery;

import com.AxonwithCQRS.AxonWithCQRS.entity.ProductEntity;
import com.AxonwithCQRS.AxonWithCQRS.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositery extends JpaRepository<ProductEntity,String> {
}
