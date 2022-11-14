package com.mustache.bb3.repository;

import com.mustache.bb3.domain.dto.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    Page<Hospital> findAll(Pageable pageable);
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
}
