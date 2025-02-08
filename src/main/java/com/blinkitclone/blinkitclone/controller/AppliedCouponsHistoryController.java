package com.blinkitclone.blinkitclone.controller;

import com.blinkitclone.blinkitclone.Exception.AlreadyDeletedException;
import com.blinkitclone.blinkitclone.Exception.NotFound;
import com.blinkitclone.blinkitclone.dto.requestDto.AppliedCouponsHistoryRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.AppliedCouponsHistoryResponseDto;
import com.blinkitclone.blinkitclone.service.AppliedCouponsHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pricing/api/v1/appliedCouponHistory")
public class AppliedCouponsHistoryController {

    @Autowired
    private AppliedCouponsHistoryService appliedCouponsHistoryService;

    @PostMapping("/create")
    public AppliedCouponsHistoryResponseDto createAppliedCouponsHistory(@RequestBody AppliedCouponsHistoryRequestDto appliedCouponsHistoryRequestDto){
        return appliedCouponsHistoryService.createAppliedCouponsHistory(appliedCouponsHistoryRequestDto);
    }

    @GetMapping("/getById")
    public AppliedCouponsHistoryResponseDto getAppliedCouponsHistoryById(@RequestParam Integer id){
        try {
            return appliedCouponsHistoryService.getAppliedCouponsHistoryById(id);
        }
        catch (NotFound | AlreadyDeletedException e){
            return AppliedCouponsHistoryResponseDto.builder().Error(e.getMessage()).build();
        }

    }

    @GetMapping("/getByCouponId")
    public AppliedCouponsHistoryResponseDto getAppliedCouponsHistoryByCouponId(@RequestParam Integer CouponId){
        try {
            return appliedCouponsHistoryService.getAppliedCouponsHistoryByCouponId(CouponId);
        }
        catch (NotFound | AlreadyDeletedException e){
            return AppliedCouponsHistoryResponseDto.builder().Error(e.getMessage()).build();
        }

    }

    @GetMapping("/getByOrderId")
    public AppliedCouponsHistoryResponseDto getAppliedCouponsHistorybyOrderId(@RequestParam Integer orderId){
        try {
            return appliedCouponsHistoryService.getAppliedCouponsHistoryByOrderId(orderId);
        }
        catch (NotFound | AlreadyDeletedException e){
            return AppliedCouponsHistoryResponseDto.builder().Error(e.getMessage()).build();
        }
    }

    @GetMapping("/getAll")
    public List<AppliedCouponsHistoryResponseDto> getAllAppliedCouponsHistory(){
        return appliedCouponsHistoryService.getAllAppliedCouponsHistory();
    }

    @PatchMapping("/updateById")
    public AppliedCouponsHistoryResponseDto updateAppliedCouponsHistoryById(@RequestParam Integer id, @RequestBody AppliedCouponsHistoryRequestDto appliedCouponsHistoryRequestDto){
        try {
            return appliedCouponsHistoryService.updateAppliedCouponsHistoryById(id, appliedCouponsHistoryRequestDto);
        }
        catch (NotFound | AlreadyDeletedException e){
            return AppliedCouponsHistoryResponseDto.builder().Error(e.getMessage()).build();
        }
    }

    @DeleteMapping("/deleteById")
    public String deleteAppliedCouponsHistoryById(@RequestParam Integer id){

        try {
            return appliedCouponsHistoryService.deleteAppliedCouponsHistoryById(id);
        }
        catch (NotFound | AlreadyDeletedException e){
            return e.getMessage();
        }
    }
}
