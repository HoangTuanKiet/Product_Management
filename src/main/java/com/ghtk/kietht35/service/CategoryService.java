package com.ghtk.kietht35.service;

import com.ghtk.kietht35.model.dto.CategoryDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface CategoryService {
    Optional<CategoryDTO> findById(int id);
}
