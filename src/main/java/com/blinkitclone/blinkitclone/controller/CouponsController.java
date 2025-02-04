package com.blinkitclone.blinkitclone.controller;

import com.blinkitclone.blinkitclone.dto.responseDto.CouponsResponseDto;
import com.blinkitclone.blinkitclone.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coupons")
public class CouponsController {
    @Autowired
    private CouponsService couponsService;

    @PostMapping("/create")
    public Boolean createCouponsService(@RequestBody String str){
        return couponsService.createCoupons(str);
    }

    @GetMapping("/getById")
    public CouponsResponseDto getCouponsById(@RequestParam Integer id){
        return couponsService.getCouponsById(id);
    }

    @PatchMapping("/updateById")
    public CouponsResponseDto updateCouponsById(@RequestParam Integer id){
        return couponsService.updateCouponsById(id);
    }

    @DeleteMapping("/deleteById")
    public CouponsResponseDto deleteCouponsById(@RequestParam Integer id){
        return couponsService.deleteCouponsById(id);
    }
}
