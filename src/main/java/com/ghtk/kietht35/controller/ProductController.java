package com.ghtk.kietht35.controller;

import com.ghtk.kietht35.model.dto.ProductDTO;
import com.ghtk.kietht35.reponsitory.ProductRepository;
import com.ghtk.kietht35.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "page_size") int pageSize
    ) {
        return productService.getAll(page, pageSize);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        return productService.findById(id);
    }

    @GetMapping("search")
    public ResponseEntity<?> search(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "page_size") int pageSize
    ){
        return ResponseEntity.ok(productService.searchByCondition(page, pageSize)).getBody();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(
            @RequestBody ProductDTO productDTO
    ) throws Exception {
        return ResponseEntity.ok(productService.create(productDTO)).getBody();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(
            @RequestBody ProductDTO product
    ){
        return ResponseEntity.ok(productService.update(product)).getBody();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(
            @PathVariable("id") int id
    ){
        return productService.deleteById(id);
    }
}
