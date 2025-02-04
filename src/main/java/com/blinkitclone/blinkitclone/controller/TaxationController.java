package com.blinkitclone.blinkitclone.controller;

import com.blinkitclone.blinkitclone.dto.requestDto.TaxationRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.TaxationResponseDto;
import com.blinkitclone.blinkitclone.service.TaxationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/taxation")
public class TaxationController {

    @Autowired
    private TaxationService taxationService;

    @PostMapping("/create")
    public TaxationResponseDto createTaxation(@RequestBody TaxationRequestDto taxationRequestDto){
        return taxationService.createTaxation(taxationRequestDto);
    }

    @GetMapping("/getById")
    public TaxationResponseDto getTaxationById(@RequestParam Integer id){
        return taxationService.getTaxationById(id);
    }

    @PatchMapping("/updateById")
    public TaxationResponseDto updateTaxationById(@RequestParam Integer id){
        return taxationService.updateTaxationById(id);
    }

    @DeleteMapping("/deleteById")
    public TaxationResponseDto deleteTaxationById(@RequestParam Integer id){
        return taxationService.deleteTaxationById(id);
    }
}
