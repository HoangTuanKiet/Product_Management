package com.ghtk.kietht35.service;

import com.ghtk.kietht35.model.dto.WarehouseDTO;
import org.springframework.http.ResponseEntity;

public interface WarehouseService {
    ResponseEntity<?> create(String warehouseName, String address, String provinceName, String districtName);

    ResponseEntity<?> update(int id, WarehouseDTO warehouseDTO);
}
