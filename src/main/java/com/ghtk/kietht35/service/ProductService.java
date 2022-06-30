package com.ghtk.kietht35.service;

import com.ghtk.kietht35.model.dto.ProductDTO;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> create(ProductDTO productDTO) throws Exception;
    ResponseEntity<?> findById(int id);
    ResponseEntity<?> deleteById(int id);
    ResponseEntity<?> searchByCondition(int page, int pageSize);
    ResponseEntity<?> getAll(int page, int pageSize);
    ResponseEntity<?> update(ProductDTO productDTO);
}
