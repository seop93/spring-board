package com.mustache.bb3.repository;


import com.mustache.bb3.domain.entity.Hospital;
import com.mustache.bb3.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
