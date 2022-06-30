package com.ghtk.kietht35.reponsitory;

import com.ghtk.kietht35.model.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Integer> {
    @Query("SELECT p FROM ProvinceEntity p WHERE p.provinceName = :name")
    ProvinceEntity getProvinceByName(@Param("name") String name);
}
