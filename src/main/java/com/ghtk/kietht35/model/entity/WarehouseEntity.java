package com.ghtk.kietht35.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "warehouse")
@Getter
@Setter
public class WarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer warehouseId;
    private String warehouseName;
    private String address;
    private Integer provinceId;
    private Integer status;
    private Integer districtId;
}
