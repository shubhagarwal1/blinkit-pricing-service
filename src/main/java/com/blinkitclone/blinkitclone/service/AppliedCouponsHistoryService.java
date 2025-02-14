package com.blinkitclone.blinkitclone.service;

import com.blinkitclone.blinkitclone.Exception.AlreadyDeletedException;
import com.blinkitclone.blinkitclone.Exception.NotFound;
import com.blinkitclone.blinkitclone.dto.requestDto.AppliedCouponsHistoryRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.AppliedCouponsHistoryResponseDto;
import com.blinkitclone.blinkitclone.entity.AppliedCouponsHistory;
import com.blinkitclone.blinkitclone.repo.AppliedCouponsHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.blinkitclone.blinkitclone.Enums.DeletionStatus.Active;
import static com.blinkitclone.blinkitclone.Enums.DeletionStatus.Deleted;

@Service
public class AppliedCouponsHistoryService {

    @Autowired
    private AppliedCouponsHistoryRepo appliedCouponsHistoryRepo;


    public AppliedCouponsHistoryResponseDto createAppliedCouponsHistory(AppliedCouponsHistoryRequestDto appliedCouponsHistoryRequestDto) {
        AppliedCouponsHistory appliedCouponsHistory = convertAppliedCouponsHistoryRequestDtoToEntity(appliedCouponsHistoryRequestDto);
        appliedCouponsHistory.setDeletionStatus(Active);
        appliedCouponsHistoryRepo.save(appliedCouponsHistory);
        return convertEntityToAppliedCouponsHistoryResponseDto(appliedCouponsHistory);
    }

    private AppliedCouponsHistoryResponseDto convertEntityToAppliedCouponsHistoryResponseDto(AppliedCouponsHistory appliedCouponsHistory) {
        return AppliedCouponsHistoryResponseDto.builder()
                .appliedAt(appliedCouponsHistory.getAppliedAt())
                .couponId(appliedCouponsHistory.getCouponId())
                .discountAmount(appliedCouponsHistory.getDiscountAmount())
                .orderId(appliedCouponsHistory.getOrderId())
                .userId(appliedCouponsHistory.getUserId())
                .orderTotalAfterDiscount(appliedCouponsHistory.getOrderTotalAfterDiscount())
                .build();
    }

    private AppliedCouponsHistory convertAppliedCouponsHistoryRequestDtoToEntity(AppliedCouponsHistoryRequestDto appliedCouponsHistoryRequestDto) {
        return AppliedCouponsHistory.builder()
                .appliedAt(appliedCouponsHistoryRequestDto.getAppliedAt())
                .couponId(appliedCouponsHistoryRequestDto.getCouponId())
                .discountAmount(appliedCouponsHistoryRequestDto.getDiscountAmount())
                .userId(appliedCouponsHistoryRequestDto.getUserId())
                .orderTotalAfterDiscount(appliedCouponsHistoryRequestDto.getOrderTotalAfterDiscount())
                .orderId(appliedCouponsHistoryRequestDto.getOrderId())
                .build();
    }

    public AppliedCouponsHistoryResponseDto getAppliedCouponsHistoryById(Integer id) throws NotFound, AlreadyDeletedException {
        Optional<AppliedCouponsHistory> appliedCouponsHistory = appliedCouponsHistoryRepo.findById(id);
        if(appliedCouponsHistory.isEmpty())
            throw new NotFound("Applied coupon history with id : " + id + " does not exist");
        if (appliedCouponsHistory.get().getDeletionStatus() == Deleted) throw new AlreadyDeletedException("Applied coupon history with id : " + id + " has been deleted");
        return convertEntityToAppliedCouponsHistoryResponseDto(appliedCouponsHistory.get());
    }

    public String deleteAppliedCouponsHistoryById(Integer id) throws NotFound, AlreadyDeletedException {

        Optional<AppliedCouponsHistory> appliedCouponsHistory = appliedCouponsHistoryRepo.findById(id);
        if(appliedCouponsHistory.isEmpty()) throw new NotFound("Applied coupon history with id : " + id + " does not exist");
        if (appliedCouponsHistory.get().getDeletionStatus() == Deleted) throw new AlreadyDeletedException("Applied coupon history with id : " + id + " has already been deleted");
        appliedCouponsHistory.get().setDeletionStatus(Deleted);
        appliedCouponsHistoryRepo.save(appliedCouponsHistory.get());
        return "successfully deleted applied coupon history with id : " + id;
    }

    public AppliedCouponsHistoryResponseDto getAppliedCouponsHistoryByCouponId(Integer couponId) throws NotFound, AlreadyDeletedException {
        Optional<AppliedCouponsHistory> appliedCouponsHistory = appliedCouponsHistoryRepo.findByCouponId(couponId);
        if(appliedCouponsHistory.isEmpty()) throw new NotFound("Applied coupon history with id : " + couponId + " does not exist");
        if (appliedCouponsHistory.get().getDeletionStatus() == Deleted) throw new AlreadyDeletedException("Applied coupon history with id : " + couponId + " has been deleted");
        return convertEntityToAppliedCouponsHistoryResponseDto(appliedCouponsHistory.get());
    }

    public AppliedCouponsHistoryResponseDto getAppliedCouponsHistoryByOrderId(Integer orderId) throws NotFound, AlreadyDeletedException {
        Optional<AppliedCouponsHistory> appliedCouponsHistory = appliedCouponsHistoryRepo.findByOrderId(orderId);
        if(appliedCouponsHistory.isEmpty()) throw new NotFound("Applied coupon history with id : " + orderId + " does not exist");
        if (appliedCouponsHistory.get().getDeletionStatus() == Deleted) throw new AlreadyDeletedException("Applied coupon history with id : " + orderId + " has been deleted");
        return convertEntityToAppliedCouponsHistoryResponseDto(appliedCouponsHistory.get());
    }

    public List<AppliedCouponsHistoryResponseDto> getAllAppliedCouponsHistory() {
        List<AppliedCouponsHistory> appliedCouponsHistoryList = appliedCouponsHistoryRepo.findAll();
        List<AppliedCouponsHistoryResponseDto> appliedCouponsHistoryResponseDtos = new ArrayList<>();
        for(AppliedCouponsHistory appliedCouponsHistory : appliedCouponsHistoryList){
            appliedCouponsHistoryResponseDtos.add(convertEntityToAppliedCouponsHistoryResponseDto(appliedCouponsHistory));
        }
        return appliedCouponsHistoryResponseDtos;
    }
}
