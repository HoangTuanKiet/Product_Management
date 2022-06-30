package com.ghtk.kietht35.service.impl;

import com.ghtk.kietht35.model.dto.WarehouseDTO;
import com.ghtk.kietht35.model.entity.WarehouseEntity;
import com.ghtk.kietht35.model.response.SampleResponse;
import com.ghtk.kietht35.reponsitory.WarehouseRepository;
import com.ghtk.kietht35.service.CategoryService;
import com.ghtk.kietht35.service.DistrictService;
import com.ghtk.kietht35.service.ProvinceService;
import com.ghtk.kietht35.service.WarehouseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<?> create(String warehouseName, String address, String provinceName, String districtName) {
        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setWarehouseName(warehouseName);
        warehouseEntity.setAddress(address + ", " + districtName + ", " + provinceName);
        warehouseEntity.setProvinceId(provinceService.getProvinceByName(provinceName).getProvinceId());
        warehouseEntity.setDistrictId(districtService.getDistrictByName(districtName).getDistrictId());
        warehouseEntity.setStatus(1);
        warehouseEntity.setCreatedAt(LocalDateTime.now());
        warehouseEntity.setModifiedAt(LocalDateTime.now());
        return ResponseEntity.ok(SampleResponse.builder()
                .success(true)
                .message("")
                .data(modelMapper.map(warehouseRepository.save(warehouseEntity), WarehouseDTO.class))
                .build());
    }

    @Override
    public ResponseEntity<?> update(int id, WarehouseDTO warehouseDTO) {
        WarehouseEntity warehouseEntity = modelMapper.map(warehouseDTO, WarehouseEntity.class);
        Optional<WarehouseEntity> oldWarehouse = warehouseRepository.findById(id);
        return oldWarehouse.map(warehouse -> {
            warehouse.setWarehouseName(warehouseEntity.getWarehouseName());
            warehouse.setAddress(warehouseEntity.getAddress());
            warehouse.setStatus(warehouseEntity.getStatus());
            warehouse.setModifiedAt(LocalDateTime.now());
            return ResponseEntity.ok(SampleResponse.builder()
                    .success(true)
                    .message("")
                    .data(warehouseRepository.save(warehouse))
                    .build());
        }).orElse(ResponseEntity.ok(SampleResponse.builder()
                    .success(false)
                    .message("warehouse not found")
                    .data(null)
                    .build()));
    }
}
