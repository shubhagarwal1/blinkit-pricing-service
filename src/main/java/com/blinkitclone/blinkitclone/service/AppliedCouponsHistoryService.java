package com.blinkitclone.blinkitclone.service;

import com.blinkitclone.blinkitclone.dto.requestDto.AppliedCouponsHistoryRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.AppliedCouponsHistoryResponseDto;
import com.blinkitclone.blinkitclone.entity.AppliedCouponsHistory;
import com.blinkitclone.blinkitclone.repo.AppliedCouponsHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppliedCouponsHistoryService {

    @Autowired
    private AppliedCouponsHistoryRepo appliedCouponsHistoryRepo;


    public AppliedCouponsHistoryResponseDto createAppliedCouponsHistory(AppliedCouponsHistoryRequestDto appliedCouponsHistoryRequestDto) {
        AppliedCouponsHistory appliedCouponsHistory = convertAppliedCouponsHistoryRequestDtoToEntity(appliedCouponsHistoryRequestDto);
        return convertEntityToAppliedCouponsHistoryResponseDto(appliedCouponsHistory);
    }

    private AppliedCouponsHistoryResponseDto convertEntityToAppliedCouponsHistoryResponseDto(AppliedCouponsHistory appliedCouponsHistory) {
        return new AppliedCouponsHistoryResponseDto();
    }

    private AppliedCouponsHistory convertAppliedCouponsHistoryRequestDtoToEntity(AppliedCouponsHistoryRequestDto appliedCouponsHistoryRequestDto) {
        AppliedCouponsHistory appliedCouponsHistory = new AppliedCouponsHistory();
        return appliedCouponsHistory;
    }

    public AppliedCouponsHistoryResponseDto getAppliedCouponsHistoryById(Integer id) {
        return new AppliedCouponsHistoryResponseDto();
    }

    public AppliedCouponsHistoryResponseDto updateAppliedCouponsHistoryById(Integer id) {
        return new AppliedCouponsHistoryResponseDto();
    }

    public AppliedCouponsHistoryResponseDto deleteAppliedCouponsHistoryById(Integer id) {
        return new AppliedCouponsHistoryResponseDto();
    }
}
