package com.antrevs.api.domain.repository;

import com.antrevs.api.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Long> {

}
