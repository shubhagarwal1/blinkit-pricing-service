package com.blinkitclone.blinkitclone.controller;

import com.blinkitclone.blinkitclone.dto.requestDto.AppliedCouponsHistoryRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.AppliedCouponsHistoryResponseDto;
import com.blinkitclone.blinkitclone.service.AppliedCouponsHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appliedCouponHistory")
public class AppliedCouponsHistoryController {

    @Autowired
    private AppliedCouponsHistoryService appliedCouponsHistoryService;

    @PostMapping("/create")
    public AppliedCouponsHistoryResponseDto createAppliedCouponsHistory(@RequestBody AppliedCouponsHistoryRequestDto appliedCouponsHistoryRequestDto){
        return appliedCouponsHistoryService.createAppliedCouponsHistory(appliedCouponsHistoryRequestDto);
    }

    @GetMapping("/getById")
    public AppliedCouponsHistoryResponseDto getAppliedCouponsHistorybyId(@RequestParam Integer id){
        return appliedCouponsHistoryService.getAppliedCouponsHistoryById(id);
    }

    @PatchMapping("/updateById")
    public AppliedCouponsHistoryResponseDto updateAppliedCouponsHistoryById(@RequestParam Integer id){
        return appliedCouponsHistoryService.updateAppliedCouponsHistoryById(id);
    }

    @DeleteMapping("/deleteById")
    public AppliedCouponsHistoryResponseDto deleteAppliedCouponsHistoryById(@RequestParam Integer id){
        return appliedCouponsHistoryService.deleteAppliedCouponsHistoryById(id);
    }
}
