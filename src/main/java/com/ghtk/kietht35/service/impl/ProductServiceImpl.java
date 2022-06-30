package com.ghtk.kietht35.service.impl;

import com.ghtk.kietht35.model.dto.ProductDTO;
import com.ghtk.kietht35.model.entity.ProductEntity;
import com.ghtk.kietht35.model.response.Pagination;
import com.ghtk.kietht35.model.response.SamplePagingResponse;
import com.ghtk.kietht35.model.response.SampleResponse;
import com.ghtk.kietht35.reponsitory.ProductRepository;
import com.ghtk.kietht35.service.CategoryService;
import com.ghtk.kietht35.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryService categoryService;

    @Override
    public ResponseEntity<?> create(ProductDTO productDTO){
        if (Optional.ofNullable(productDTO)
                .filter(p -> p.getProductName() != null)
                .filter(p -> p.getProductName().length() < 100)
                .filter(p -> p.getPrice() > 0)
                .isPresent())
        {
            ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);
            productEntity.setStatus(1);
            productEntity.setCreatedAt(LocalDateTime.now());
            productEntity.setModifiedAt(LocalDateTime.now());
            productEntity.setCode(categoryService.findById(productDTO.getCategoryId()).get().getCode()
                    + "."
                    + productDTO.getSku()
                    + "."
                    + productEntity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
            return ResponseEntity.ok(SampleResponse.builder()
                    .success(true)
                    .message("")
                    .data(modelMapper.map(productRepository.save(productEntity), ProductDTO.class))
                    .build());
        }else{
            return ResponseEntity.ok(SampleResponse.builder()
                    .success(false)
                    .message("")
                    .data(null)
                    .build());
        }

    }

    @Override
    public ResponseEntity<?> findById(int id) {
        try {
            Optional<ProductEntity> productEntity = productRepository.findById(id);
            return ResponseEntity.ok(productEntity.map(product -> SampleResponse.builder()
                            .success(true)
                            .message("")
                            .data(modelMapper.map(product, ProductDTO.class))
                            .build())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found")));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok(SampleResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .data(null)
                    .build());
        }
    }

    @Override
    public ResponseEntity<?> deleteById(int id) {
        try {
            Optional<ProductEntity> productEntity = productRepository.findById(id);
            return ResponseEntity.ok(productEntity.map(product -> {
                product.setStatus(0);
                product.setModifiedAt(LocalDateTime.now());
                return SampleResponse.builder()
                        .success(true)
                        .message("")
                        .data(modelMapper.map(productRepository.save(product), ProductDTO.class))
                        .build();
            }).orElseThrow(() -> new EntityNotFoundException("Product not found")));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok(SampleResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .data(null)
                    .build());
        }
    }

    @Override
    public ResponseEntity<?> searchByCondition(int page, int pageSize) {
        Page<ProductEntity> productEntity= productRepository.searchByCondition(PageRequest.of(page, pageSize, Sort.Direction.DESC, "price"));
        Page<ProductDTO> productDTO = productEntity.map(product -> modelMapper.map(product, ProductDTO.class));
        if (productDTO.getContent().size() > 0) {
            return ResponseEntity.ok(SamplePagingResponse.builder()
                    .success(true)
                    .message("")
                    .data(productDTO)
                    .pagination(Pagination.builder()
                            .page(page)
                            .pageSize(pageSize)
                            .totalPage(productDTO.getTotalPages())
                            .totalRecord(productDTO.getTotalElements())
                            .build())
                    .build());
        } else {
            return ResponseEntity.ok(SampleResponse.builder()
                    .success(false)
                    .message("Not found product")
                    .data(null)
                    .build());
        }
    }

    @Override
    public ResponseEntity<?> getAll(int page, int pageSize) {
        Page<ProductEntity> productEntities = productRepository.findAll(PageRequest.of(page, pageSize));
        if (productEntities.hasContent()) {
            return ResponseEntity.ok(SamplePagingResponse.builder()
                    .success(true)
                    .message("")
                    .data(modelMapper.map(productEntities.get(), ProductDTO.class))
                    .pagination(Pagination.builder()
                            .page(page)
                            .pageSize(pageSize)
                            .totalPage(productEntities.getTotalPages())
                            .totalRecord(productEntities.getTotalElements())
                            .build())
                    .build());
        } else {
            return ResponseEntity.ok(SampleResponse.builder()
                    .success(false)
                    .message("Product not found")
                    .data(null)
                    .build());
        }
    }

    @Override
    public ResponseEntity<?> update(ProductDTO productDTO) {
        if (Optional.ofNullable(productDTO)
                .filter(p -> p.getProductName() != null)
                .filter(p -> p.getProductName().length() < 100)
                .filter(p -> p.getPrice() > 0)
                .isPresent()) {
            ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);
            productEntity.setModifiedAt(LocalDateTime.now());
            return ResponseEntity.ok(SampleResponse.builder()
                    .success(true)
                    .message("")
                    .data(modelMapper.map(productRepository.save(productEntity), ProductDTO.class))
                    .build());
        } else {
            return ResponseEntity.ok(SampleResponse.builder()
                    .success(false)
                    .message("Product not found")
                    .data(null)
                    .build());
        }
    }
}
