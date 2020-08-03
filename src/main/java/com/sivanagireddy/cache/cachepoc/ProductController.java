package com.sivanagireddy.cache.cachepoc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Product product) {
        productRepository.save(product);
    }

    @GetMapping
    public Collection<Product> findAll(){
        return productRepository.getAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productRepository.getById(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Collections.singletonMap("error",ex.getMessage()));
    }
}
