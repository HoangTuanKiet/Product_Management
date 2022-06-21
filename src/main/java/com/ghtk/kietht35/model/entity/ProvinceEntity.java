package com.ghtk.kietht35.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "province")
@Getter
@Setter
public class ProvinceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer provinceId;
    private String provinceCode;
    private String provinceName;
}
