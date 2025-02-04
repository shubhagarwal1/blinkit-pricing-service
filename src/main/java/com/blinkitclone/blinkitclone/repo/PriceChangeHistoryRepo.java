package com.blinkitclone.blinkitclone.repo;

import com.blinkitclone.blinkitclone.entity.PriceChangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceChangeHistoryRepo extends JpaRepository<PriceChangeHistory, Integer> {
}
