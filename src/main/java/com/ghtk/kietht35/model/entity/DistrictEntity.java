package com.ghtk.kietht35.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "district")
@Getter
@Setter
public class DistrictEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer districtId;
    private String districtCode;
    private String districtName;
}
