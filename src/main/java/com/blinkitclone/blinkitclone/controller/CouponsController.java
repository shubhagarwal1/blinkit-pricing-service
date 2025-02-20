package com.blinkitclone.blinkitclone.controller;

import com.blinkitclone.blinkitclone.Exception.AlreadyDeletedException;
import com.blinkitclone.blinkitclone.Exception.CouponExpiredException;
import com.blinkitclone.blinkitclone.Exception.NotFoundException;
import com.blinkitclone.blinkitclone.dto.requestDto.CouponsRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.CouponsResponseDto;
import com.blinkitclone.blinkitclone.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pricing/api/v1/coupons")
public class CouponsController {
    @Autowired
    private CouponsService couponsService;

    @PostMapping("/create")
    public ResponseEntity<CouponsResponseDto> createCouponsService(@RequestBody CouponsRequestDto couponsRequestDto){
        return new ResponseEntity<>(couponsService.createCoupons(couponsRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/getByCouponCode")
    public ResponseEntity<CouponsResponseDto> getCouponsByCouponCode(@RequestParam String couponCode){
        try{
            return new ResponseEntity<>(couponsService.getCouponsByCouponCode(couponCode), HttpStatus.FOUND);
        }
        catch (CouponExpiredException | NotFoundException e){
            return new ResponseEntity<>(CouponsResponseDto.builder().error(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<CouponsResponseDto> getCouponsById(@RequestParam Integer id){
        try{
            return new ResponseEntity<>( couponsService.getCouponsById(id), HttpStatus.OK);
        }
        catch (CouponExpiredException | NotFoundException e){
            return new ResponseEntity<>( CouponsResponseDto.builder().error(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllActiveCoupons")
    public ResponseEntity<List<CouponsResponseDto>> getAllActiveCoupons(){

        return new ResponseEntity<>(couponsService.getAllActiveCoupons(), HttpStatus.FOUND);
    }

    @GetMapping("/getAllCoupons")

    public ResponseEntity<List<CouponsResponseDto>> getAllCoupons(){

        return new ResponseEntity<>( couponsService.getAllCoupons(), HttpStatus.FOUND);
    }

    @PatchMapping("/updateById")
    public ResponseEntity<CouponsResponseDto> updateCouponsById(@RequestParam Integer id, @RequestBody CouponsRequestDto couponsRequestDto){
        try{
            return new ResponseEntity<>( couponsService.updateCouponsById(id, couponsRequestDto), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>( CouponsResponseDto.builder().error(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteCouponsById(@RequestParam Integer id){
        try{
            return new ResponseEntity<>(couponsService.deleteCouponsById(id), HttpStatus.OK);
        } catch (AlreadyDeletedException | NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
