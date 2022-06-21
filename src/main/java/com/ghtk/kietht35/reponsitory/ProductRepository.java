package com.ghtk.kietht35.reponsitory;

import com.ghtk.kietht35.model.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
    @Query("SELECT p FROM ProductEntity p WHERE p.price > 50000 AND p.productName like '%a%' ORDER BY p.price DESC")
    Page<ProductEntity> searchByCondition(Pageable pageable);

}
