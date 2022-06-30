package com.ghtk.kietht35.service.impl;

import com.ghtk.kietht35.model.dto.CategoryDTO;
import com.ghtk.kietht35.model.entity.CategoryEntity;
import com.ghtk.kietht35.reponsitory.CategoryRepository;
import com.ghtk.kietht35.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Optional<CategoryDTO> findById(int id) {
        return categoryRepository.findById(id).map(categoryEntity -> modelMapper.map(categoryEntity, CategoryDTO.class));
    }
}
