package com.ghtk.kietht35.reponsitory;

import com.ghtk.kietht35.model.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DistrictRepository extends JpaRepository<DistrictEntity, Integer> {
    @Query("SELECT d FROM DistrictEntity d WHERE d.districtName = :districtName")
    DistrictEntity getDistrictByName(@Param("districtName") String name);
}
