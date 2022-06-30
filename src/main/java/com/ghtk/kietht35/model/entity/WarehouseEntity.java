package com.ghtk.kietht35.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "warehouse")
@Getter
@Setter
public class WarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("warehouse_id")
    private Integer warehouseId;

    @JsonProperty("warehouse_name")
    private String warehouseName;

    private String address;

    @JsonProperty("province_id")
    private Integer provinceId;

    @JsonProperty("district_id")
    private Integer districtId;

    private Integer status;

    @CreatedDate
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @JsonProperty("modified_at")
    private LocalDateTime modifiedAt;
}
