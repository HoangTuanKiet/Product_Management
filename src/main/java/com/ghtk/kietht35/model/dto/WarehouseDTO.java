package com.ghtk.kietht35.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseDTO {
    @JsonProperty("warehouse_name")
    private String warehouseName;

    private String address;

    @JsonProperty("province_id")
    private Integer provinceId;

    @JsonProperty("district_id")
    private Integer districtId;

}
