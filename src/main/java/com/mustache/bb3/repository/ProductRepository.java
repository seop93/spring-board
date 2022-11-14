package com.mustache.bb3.repository;

import com.mustache.bb3.domain.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
