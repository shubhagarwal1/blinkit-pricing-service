package com.blinkitclone.blinkitclone.controller;

import com.blinkitclone.blinkitclone.Exception.AlreadyDeletedException;
import com.blinkitclone.blinkitclone.Exception.NotFound;
import com.blinkitclone.blinkitclone.dto.requestDto.AppliedCouponsHistoryRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.AppliedCouponsHistoryResponseDto;
import com.blinkitclone.blinkitclone.service.AppliedCouponsHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pricing/api/v1/appliedCouponHistory")
public class AppliedCouponsHistoryController {

    @Autowired
    private AppliedCouponsHistoryService appliedCouponsHistoryService;


    @GetMapping("/getById")
    public ResponseEntity<AppliedCouponsHistoryResponseDto> getAppliedCouponsHistoryById(@RequestParam Integer id){
        try {
            return new ResponseEntity<>(appliedCouponsHistoryService.getAppliedCouponsHistoryById(id), HttpStatus.OK);
        }
        catch (NotFound | AlreadyDeletedException e){
            return new ResponseEntity<>(AppliedCouponsHistoryResponseDto.builder().error(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getByCouponId")
    public ResponseEntity<AppliedCouponsHistoryResponseDto> getAppliedCouponsHistoryByCouponId(@RequestParam Integer CouponId){
        try {
            return new ResponseEntity<>(appliedCouponsHistoryService.getAppliedCouponsHistoryByCouponId(CouponId), HttpStatus.OK);
        }
        catch (NotFound | AlreadyDeletedException e){
            return new ResponseEntity<>(AppliedCouponsHistoryResponseDto.builder().error(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getByOrderId")
    public ResponseEntity<AppliedCouponsHistoryResponseDto> getAppliedCouponsHistorybyOrderId(@RequestParam Integer orderId){
        try {
            return new ResponseEntity<>(appliedCouponsHistoryService.getAppliedCouponsHistoryByOrderId(orderId), HttpStatus.OK);
        }
        catch (NotFound | AlreadyDeletedException e){
            return new ResponseEntity<>(AppliedCouponsHistoryResponseDto.builder().error(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AppliedCouponsHistoryResponseDto>> getAllAppliedCouponsHistory(){
        return new ResponseEntity<>(appliedCouponsHistoryService.getAllAppliedCouponsHistory(), HttpStatus.OK);
    }

}
