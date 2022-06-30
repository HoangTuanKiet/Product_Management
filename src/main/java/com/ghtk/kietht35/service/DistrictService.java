package com.ghtk.kietht35.service;

import com.ghtk.kietht35.model.dto.DistrictDTO;
import com.ghtk.kietht35.model.entity.DistrictEntity;

public interface DistrictService {
    DistrictEntity getDistrictByName(String name);
}
