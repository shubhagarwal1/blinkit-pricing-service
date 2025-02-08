package com.blinkitclone.blinkitclone.controller;

import com.blinkitclone.blinkitclone.Exception.AlreadyDeletedException;
import com.blinkitclone.blinkitclone.Exception.CouponExpiredException;
import com.blinkitclone.blinkitclone.Exception.CouponNotFoundException;
import com.blinkitclone.blinkitclone.dto.requestDto.CouponsRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.CouponsResponseDto;
import com.blinkitclone.blinkitclone.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coupons")
public class CouponsController {
    @Autowired
    private CouponsService couponsService;

    @PostMapping("/create")
    public CouponsResponseDto createCouponsService(@RequestBody CouponsRequestDto couponsRequestDto){
        return couponsService.createCoupons(couponsRequestDto);
    }

    @GetMapping("/getByCouponCode")
    public CouponsResponseDto getCouponsByCouponCode(@RequestParam String couponCode){
        try{
            return couponsService.getCouponsByCouponCode(couponCode);
        }
        catch (CouponExpiredException | CouponNotFoundException e){
            return CouponsResponseDto.builder().error(e.getMessage()).build();
        }
    }

    @GetMapping("/getById")
    public CouponsResponseDto getCouponsById(@RequestParam Integer id){
        try{
            return couponsService.getCouponsById(id);
        }
        catch (CouponExpiredException | CouponNotFoundException e){
            return CouponsResponseDto.builder().error(e.getMessage()).build();
        }
    }

    @GetMapping("/getAllActiveCoupons")
    public List<CouponsResponseDto> getAllActiveCoupons(){
        return couponsService.getAllActiveCoupons();
    }

    @GetMapping("/getAllCoupons")

    public List<CouponsResponseDto> getAllCoupons(){
        return couponsService.getAllCoupons();
    }

    @PatchMapping("/updateById")
    public CouponsResponseDto updateCouponsById(@RequestParam Integer id, @RequestBody CouponsRequestDto couponsRequestDto){
        try{
            return couponsService.updateCouponsById(id, couponsRequestDto);
        } catch (CouponNotFoundException e) {
            return CouponsResponseDto.builder().error(e.getMessage()).build();
        }
    }

    @DeleteMapping("/deleteById")
    public String deleteCouponsById(@RequestParam Integer id){
        try{
            return couponsService.deleteCouponsById(id);
        } catch (AlreadyDeletedException | CouponNotFoundException e) {
            return e.getMessage();
        }
    }
}
