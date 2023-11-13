package com.alten.shop.products.controllers;

import com.alten.shop.products.dto.ProductDto;
import com.alten.shop.products.service.ProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController{


    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    List<ProductDto> getAll(){
        return this.productsService.getAll();
    }

    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto) {
        ProductDto addedProduct = productsService.saveProduct(productDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{productId}")
                .buildAndExpand(addedProduct.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> addProduct(@PathVariable String productId, @RequestBody ProductDto productDto) {
        ProductDto addedProduct = productsService.updateProduct(productId, productDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{productId}")
                .buildAndExpand(addedProduct.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/{productId}")
    void deleteProduct(@PathVariable String productId){
        this.productsService.deleteProduct(productId);

    }

    @GetMapping("/{productId}")
    ProductDto getProduct(@PathVariable String productId){
       return this.productsService.getProduct(productId);

    }
}