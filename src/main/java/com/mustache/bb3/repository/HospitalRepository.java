package com.mustache.bb3.repository;

import com.mustache.bb3.domain.dto.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
