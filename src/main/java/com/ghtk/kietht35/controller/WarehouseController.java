package com.ghtk.kietht35.controller;

import com.ghtk.kietht35.model.dto.WarehouseDTO;
import com.ghtk.kietht35.service.DistrictService;
import com.ghtk.kietht35.service.ProvinceService;
import com.ghtk.kietht35.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;


    @PostMapping("/create")
    public ResponseEntity<?> create(
            @RequestParam(value = "warehouse_name") String warehouseName,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "province_name") String provinceName,
            @RequestParam(value = "district_name") String districtName
    ){
        return ResponseEntity.ok(warehouseService.create(warehouseName, address, provinceName, districtName));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(
            @RequestParam(value = "id") int id,
            @RequestBody WarehouseDTO warehouseDTO
    ){
        return ResponseEntity.ok(warehouseService.update(id, warehouseDTO)).getBody();
    }
}
