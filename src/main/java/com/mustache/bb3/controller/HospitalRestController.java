package com.mustache.bb3.controller;

import com.mustache.bb3.domain.dto.HospitalResponse;
import com.mustache.bb3.domain.entity.Hospital;
import com.mustache.bb3.repository.HospitalRepository;
import com.mustache.bb3.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {
    HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService){
        this.hospitalService=hospitalService;
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id){
        HospitalResponse hospitalResponse = hospitalService.getHospital(id); // DTO
        return ResponseEntity.ok().body(hospitalResponse); // Return은 DTO로

    }
}
