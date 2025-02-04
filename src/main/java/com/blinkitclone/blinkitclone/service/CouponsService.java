package com.blinkitclone.blinkitclone.service;

import com.blinkitclone.blinkitclone.dto.responseDto.CouponsResponseDto;
import com.blinkitclone.blinkitclone.repo.CouponsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponsService {

    @Autowired
    private CouponsRepo couponsRepo;


    public Boolean createCoupons(String str) {
        return true;
    }

    public CouponsResponseDto getCouponsById(Integer id) {
        return new CouponsResponseDto();
    }

    public CouponsResponseDto updateCouponsById(Integer id) {
        return new CouponsResponseDto();
    }

    public CouponsResponseDto deleteCouponsById(Integer id) {
        return new CouponsResponseDto();
    }
}
