package com.mustache.bb3.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nation_wide_hospitals") //hospital 이라는 테이블이 아님
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {

    @Id // GenratedValue안씀
    private Integer id;

    @Column(name = "road_name_address")
    private String roadNameAddress;

    @Column(name = "hospital_name")
    private String hospitalName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private Float totalAreaSize;
}
