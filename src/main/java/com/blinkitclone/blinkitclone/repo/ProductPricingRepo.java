package com.blinkitclone.blinkitclone.repo;

import com.blinkitclone.blinkitclone.entity.ProductPricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPricingRepo extends JpaRepository<ProductPricing, Integer> {
}
