package com.ghtk.kietht35.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "warehouse_product")
@Getter
@Setter
public class WarehouseProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer productId;
    private Integer warehouseId;
    private Integer inventory;
    private Integer totalImport;
    private Integer totalExport;
    private Date startDate;
    private Date expiredDate;
}
