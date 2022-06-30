package com.ghtk.kietht35.service.impl;

import com.ghtk.kietht35.model.dto.ProvinceDTO;
import com.ghtk.kietht35.model.entity.ProvinceEntity;
import com.ghtk.kietht35.reponsitory.ProvinceRepository;
import com.ghtk.kietht35.service.ProvinceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public ProvinceEntity getProvinceByName(String name) {
        return provinceRepository.getProvinceByName(name);
    }
}
