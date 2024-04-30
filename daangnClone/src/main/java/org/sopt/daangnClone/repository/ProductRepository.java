package org.sopt.daangnClone.repository;

import org.sopt.daangnClone.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
