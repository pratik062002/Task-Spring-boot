package com.example.submission.CRUD.controller;



import com.example.submission.CRUD.entity.*;
import com.example.submission.CRUD.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page) {
        return productRepository.findAll(PageRequest.of(page, 10));
    }

    @PostMapping
    public product createProduct(@RequestBody product product) {
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Optional<product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    @PutMapping("/{id}")
    public product updateProduct(@PathVariable Long id, @RequestBody product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
