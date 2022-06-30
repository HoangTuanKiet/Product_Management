package com.ghtk.kietht35.service.impl;

import com.ghtk.kietht35.model.entity.DistrictEntity;
import com.ghtk.kietht35.reponsitory.DistrictRepository;
import com.ghtk.kietht35.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public DistrictEntity getDistrictByName(String name) {
        return districtRepository.getDistrictByName(name);
    }
}
