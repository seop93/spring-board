package com.mustache.bb3.repository;

import com.mustache.bb3.domain.entity.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
    List<Hospital> findByRoadNameAddressContaining(String address);

    List<Hospital> findByHospitalNameStartingWith(String keyword);
    List<Hospital> findByTotalNumberOfBedsBetween(int start, int end);
    List<Hospital> findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(int start, int end);

}
