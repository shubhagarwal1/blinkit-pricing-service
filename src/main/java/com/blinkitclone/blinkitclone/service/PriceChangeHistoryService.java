package com.blinkitclone.blinkitclone.service;

import com.blinkitclone.blinkitclone.dto.requestDto.PriceChangeHistoryRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.PriceChangeHistoryResponseDto;
import com.blinkitclone.blinkitclone.repo.PriceChangeHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceChangeHistoryService {

    @Autowired
    private PriceChangeHistoryRepo priceChangeHistoryRepo;

    public PriceChangeHistoryResponseDto createPriceChangeHistory(PriceChangeHistoryRequestDto priceChangeHistoryRequestDto) {
        return new PriceChangeHistoryResponseDto();
    }

    public PriceChangeHistoryResponseDto getPriceChangeHistoryById(Integer id) {
        return new PriceChangeHistoryResponseDto();
    }

    public PriceChangeHistoryResponseDto updatePriceChangeHistoryById(Integer id) {
        return new PriceChangeHistoryResponseDto();
    }

    public PriceChangeHistoryResponseDto deletePriceChangeHistoryById(Integer id) {
        return new PriceChangeHistoryResponseDto();
    }
}
