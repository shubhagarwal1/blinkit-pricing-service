package com.blinkitclone.blinkitclone.repo;

import com.blinkitclone.blinkitclone.entity.AppliedCouponsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppliedCouponsHistoryRepo extends JpaRepository<AppliedCouponsHistory, Integer> {
}
