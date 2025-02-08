package com.blinkitclone.blinkitclone.service;

import com.blinkitclone.blinkitclone.Enums.CouponStatus;
import com.blinkitclone.blinkitclone.Exception.AlreadyDeletedException;
import com.blinkitclone.blinkitclone.Exception.CouponExpiredException;
import com.blinkitclone.blinkitclone.Exception.CouponNotFoundException;
import com.blinkitclone.blinkitclone.dto.requestDto.CouponsRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.CouponsResponseDto;
import com.blinkitclone.blinkitclone.entity.Coupons;
import com.blinkitclone.blinkitclone.repo.CouponsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Optional;

import static com.blinkitclone.blinkitclone.Enums.DeletionStatus.Active;
import static com.blinkitclone.blinkitclone.Enums.DeletionStatus.Deleted;

@Service
public class CouponsService {

    @Autowired
    private CouponsRepo couponsRepo;


    public CouponsResponseDto createCoupons(CouponsRequestDto couponsRequestDto) {
        Coupons coupons = ConvertCouponsRequestDtoToCoupon(couponsRequestDto);
        coupons.setDeletionStatus(Deleted);
        couponsRepo.save(coupons);
        return ConvertCouponToCouponsResponseDto(coupons);
    }

    private Coupons ConvertCouponsRequestDtoToCoupon(CouponsRequestDto couponsRequestDto) {
        return Coupons.builder()
                .applyingCondition(couponsRequestDto.getApplyingCondition())
                .couponCode(couponsRequestDto.getCouponCode())
                .mov(couponsRequestDto.getMov())
                .applicableCategory(couponsRequestDto.getApplicableCategory())
                .endDate(couponsRequestDto.getEndDate())
                .createdById(couponsRequestDto.getCreatedById())
                .description(couponsRequestDto.getDescription())
                .discountType(couponsRequestDto.getDiscountType())
                .maxDiscount(couponsRequestDto.getMaxDiscount())
                .startDate(couponsRequestDto.getStartDate())
                .maxUsage(couponsRequestDto.getMaxUsage())
                .maxUsagePerUser(couponsRequestDto.getMaxUsagePerUser())
                .status(couponsRequestDto.getStatus())
                .redeemedCount(couponsRequestDto.getRedeemedCount())
                .build();
    }

    public CouponsResponseDto getCouponsByCouponCode(String couponCode)throws CouponNotFoundException, CouponExpiredException {
        Optional<Coupons> coupons = couponsRepo.findByCouponCode(couponCode);
        if(coupons.isEmpty()) throw new CouponNotFoundException("Coupon with coupon code : " + couponCode + " does not exist");
        if(coupons.get().getStatus() == CouponStatus.Expired) throw new CouponExpiredException("Coupon with coupon code : " + couponCode + "has already been expired");
        return ConvertCouponToCouponsResponseDto(coupons.get());
    }

    private CouponsResponseDto ConvertCouponToCouponsResponseDto(Coupons coupons) {
        return CouponsResponseDto.builder()
                .couponCode(coupons.getCouponCode())
                .applicableCategory(coupons.getApplicableCategory())
                .applyingCondition(coupons.getApplyingCondition())
                .mov(coupons.getMov())
                .description(coupons.getDescription())
                .discountType(coupons.getDiscountType())
                .maxDiscount(coupons.getMaxDiscount())
                .endDate(coupons.getEndDate())
                .startDate(coupons.getStartDate())
                .build();
    }

    public CouponsResponseDto updateCouponsById(Integer id, CouponsRequestDto couponsRequestDto) throws CouponNotFoundException{
        Optional<Coupons> coupons = couponsRepo.findById(id);
        if(coupons.isEmpty()) throw new CouponNotFoundException("Coupon with coupon id : " + id + " does not exist");
        if(couponsRequestDto.getCouponCode() != null) coupons.get().setCouponCode(couponsRequestDto.getCouponCode());
        if(couponsRequestDto.getDescription() != null) coupons.get().setDescription(couponsRequestDto.getDescription());
        if(couponsRequestDto.getMaxUsagePerUser() != null) coupons.get().setMaxUsagePerUser(couponsRequestDto.getMaxUsagePerUser());
        if(couponsRequestDto.getMaxUsage() != null) coupons.get().setMaxUsage(couponsRequestDto.getMaxUsage());
        if(couponsRequestDto.getMov() != null) coupons.get().setMov(couponsRequestDto.getMov());
        if(couponsRequestDto.getApplicableCategory() != null) coupons.get().setApplicableCategory(couponsRequestDto.getApplicableCategory());
        if(couponsRequestDto.getDiscountType() != null) coupons.get().setDiscountType(couponsRequestDto.getDiscountType());
        if(couponsRequestDto.getStatus() != null) coupons.get().setStatus(couponsRequestDto.getStatus());
        if(couponsRequestDto.getEndDate() != null) coupons.get().setEndDate(couponsRequestDto.getEndDate());
        if(couponsRequestDto.getApplyingCondition() != null) coupons.get().setApplyingCondition(couponsRequestDto.getApplyingCondition());
        if(couponsRequestDto.getCreatedById() != null) coupons.get().setCreatedById(couponsRequestDto.getCreatedById());
        if(couponsRequestDto.getMaxDiscount() != null) coupons.get().setMaxDiscount(couponsRequestDto.getMaxDiscount());
        if(couponsRequestDto.getRedeemedCount() != null) coupons.get().setRedeemedCount(couponsRequestDto.getRedeemedCount());
        if(couponsRequestDto.getStartDate() != null) coupons.get().setStartDate(couponsRequestDto.getStartDate());

        couponsRepo.save(coupons.get());
        return new CouponsResponseDto();
    }

    public String deleteCouponsById(Integer id) throws AlreadyDeletedException, CouponNotFoundException {
        Optional<Coupons> coupons = couponsRepo.findById(id);
        if(coupons.isEmpty()) throw new CouponNotFoundException("Coupon with coupon id : " + id + " does not exist");
        if(coupons.get().getDeletionStatus() == Deleted) throw new AlreadyDeletedException("Coupon with coupon id : " + id + " has already been deleted");
        coupons.get().setDeletionStatus(Deleted);
        couponsRepo.save(coupons.get());
        return "successfully deleted coupon with coupon id : " + id;
    }

    public CouponsResponseDto getCouponsById(Integer id) throws CouponExpiredException, CouponNotFoundException {
        Optional<Coupons> coupons = couponsRepo.findById(id);
        if(coupons.isEmpty()) throw new CouponNotFoundException("Coupon with coupon code : " + id + " does not exist");
        if(coupons.get().getStatus() == CouponStatus.Expired) throw new CouponExpiredException("Coupon with coupon code : " + id + "has already been expired");
        return ConvertCouponToCouponsResponseDto(coupons.get());
    }

    public List<CouponsResponseDto> getAllActiveCoupons() {
        List<Coupons> couponsList = couponsRepo.findAll();
        List<CouponsResponseDto> couponsResponseDtos = new ArrayList<>();
        for(Coupons coupons : couponsList){
            if(coupons.getStatus() == CouponStatus.Active && coupons.getDeletionStatus() == Active){
                couponsResponseDtos.add(ConvertCouponToCouponsResponseDto(coupons));
            }
        }
        return couponsResponseDtos;
    }

    public List<CouponsResponseDto> getAllCoupons() {
        List<Coupons> couponsList = couponsRepo.findAll();
        List<CouponsResponseDto> couponsResponseDtos = new ArrayList<>();
        for(Coupons coupons : couponsList){
                couponsResponseDtos.add(ConvertCouponToCouponsResponseDto(coupons));
        }
        return couponsResponseDtos;
    }
}
