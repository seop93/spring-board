package com.mustache.bb3.domain.dto;

import com.mustache.bb3.domain.entity.Hospital;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HospitalResponse {
    private Integer id;
    private String roadNameAddress;
    private String hospitalName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private Float totalAreaSize;
    private String businessStatusName;

    public HospitalResponse(Integer id, String roadNameAddress, String hospitalName, Integer patientRoomCount, Integer totalNumberOfBeds, String businessTypeName, Float totalAreaSize) {
        this.id=id;
        this.roadNameAddress=roadNameAddress;
        this.hospitalName=hospitalName;
        this.patientRoomCount=patientRoomCount;
        this.totalNumberOfBeds=totalNumberOfBeds;
        this.totalAreaSize=totalAreaSize;
        this.businessTypeName=businessTypeName;
    }

    public void setBusinessStatusName(String businessStatusName) {
        this.businessStatusName = businessStatusName;
    }
}
