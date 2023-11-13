package com.alten.shop.products.service;

import com.alten.shop.products.dto.ProductDto;
import com.alten.shop.products.entities.ProductEntity;
import com.alten.shop.products.exceptions.ProductNonFoundException;
import com.alten.shop.products.mappers.ProductsMapper;
import com.alten.shop.products.repo.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService{

    public static final String NO_PRODUCT_WITH_THE_GIVEN_ID_FOUND = "No product with the given id found";
    private final ProductsRepository productsRepository;

    private final ProductsMapper productsMapper;

    public ProductsService(ProductsRepository productsRepository, ProductsMapper productsMapper) {
        this.productsRepository = productsRepository;
        this.productsMapper = productsMapper;
    }

    /**
     * Get all products
     * @return a list of @link Product
     */
    public List<ProductDto> getAll(){
        return this.productsRepository.findAll().stream().map(this.productsMapper::toDto).toList();
    }

    /**
     * Retur a product by id
     * @param productId the id of the product to consult
     * @return
     */
    public ProductDto getProduct(String productId) {
        return productsRepository.findById(productId)
                .map(productsMapper::toDto)
                .orElseThrow(() -> new ProductNonFoundException(NO_PRODUCT_WITH_THE_GIVEN_ID_FOUND));
    }



    public void deleteProduct(String productId){
        ProductEntity productEntity = productsRepository.findById(productId)
                .orElseThrow(() -> new ProductNonFoundException(NO_PRODUCT_WITH_THE_GIVEN_ID_FOUND));
         this.productsRepository.delete(productEntity);
    }

    public ProductDto saveProduct(ProductDto productDto){
        ProductEntity  productEntity =  this.productsMapper.toEntity(productDto);
        return this.productsMapper.toDto(this.productsRepository.save(productEntity));
    }

    public ProductDto updateProduct(String productId, ProductDto productDto){
        ProductEntity productEntity = productsRepository.findById(productId)
                .orElseThrow(() -> new ProductNonFoundException(NO_PRODUCT_WITH_THE_GIVEN_ID_FOUND));

        productEntity.setCategory(productDto.getCategory());
        productEntity.setImage(productDto.getImage());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setRating(productDto.getRating());
        return this.productsMapper.toDto(this.productsRepository.save(productEntity));


    }
}