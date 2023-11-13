package com.alten.shop.products.repo;

import com.alten.shop.products.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends MongoRepository<ProductEntity, String> {
}