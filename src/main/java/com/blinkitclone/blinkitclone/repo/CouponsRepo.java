package com.blinkitclone.blinkitclone.repo;

import com.blinkitclone.blinkitclone.entity.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponsRepo extends JpaRepository<Coupons, Integer> {
}
