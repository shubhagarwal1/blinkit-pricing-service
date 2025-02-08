package com.blinkitclone.blinkitclone.repo;

import com.blinkitclone.blinkitclone.entity.AppliedCouponsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppliedCouponsHistoryRepo extends JpaRepository<AppliedCouponsHistory, Integer> {
    Optional<AppliedCouponsHistory> findByCouponId(Integer couponId);

    Optional<AppliedCouponsHistory> findByOrderId(Integer orderId);
}
