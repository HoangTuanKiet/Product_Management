package com.ghtk.kietht35.reponsitory;

import com.ghtk.kietht35.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
