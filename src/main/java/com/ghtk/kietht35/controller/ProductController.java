package com.ghtk.kietht35.controller;

import com.ghtk.kietht35.model.entity.ProductEntity;
import com.ghtk.kietht35.reponsitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "page_size") int pageSize
    ){
        Page<ProductEntity> productEntities = productRepository.findAll(PageRequest.of(page, pageSize));
        return ResponseEntity.ok(productEntities);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(
            @RequestBody ProductEntity product
    ){
        return ResponseEntity.ok(productRepository.save(product));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(
            @RequestBody ProductEntity product
    ){
        return ResponseEntity.ok(productRepository.save(product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(
            @PathVariable("id") int id
    ){
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isEmpty()){
            return ResponseEntity.ok("No content!!!");
        }else {
            productRepository.deleteById(id);
            return ResponseEntity.ok("Delete Success!!!");
        }
    }

    @GetMapping("search")
    public ResponseEntity<?> search(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "page_size") int pageSize
    ){
        return ResponseEntity.ok(productRepository.searchByCondition(PageRequest.of(page, pageSize)));
    }
}
