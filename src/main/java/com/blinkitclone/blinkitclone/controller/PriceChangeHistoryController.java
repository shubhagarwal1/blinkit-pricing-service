package com.blinkitclone.blinkitclone.controller;

import com.blinkitclone.blinkitclone.dto.requestDto.PriceChangeHistoryRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.PriceChangeHistoryResponseDto;
import com.blinkitclone.blinkitclone.service.PriceChangeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/priceChangeHistory")
public class PriceChangeHistoryController {

    @Autowired
    private PriceChangeHistoryService priceChangeHistoryService;

    @PostMapping("/create")
    public PriceChangeHistoryResponseDto createPriceChangeHistory(@RequestBody PriceChangeHistoryRequestDto priceChangeHistoryRequestDto){
        return priceChangeHistoryService.createPriceChangeHistory(priceChangeHistoryRequestDto);
    }

    @GetMapping("/getById")
    public PriceChangeHistoryResponseDto getPriceChangeHistoryById(@RequestParam Integer id){
        return priceChangeHistoryService.getPriceChangeHistoryById(id);
    }

    @PatchMapping("/updateById")
    public PriceChangeHistoryResponseDto updatePriceChangeHistoryById(@RequestParam Integer id){
        return priceChangeHistoryService.updatePriceChangeHistoryById(id);
    }

    @DeleteMapping("/deleteById")
    public PriceChangeHistoryResponseDto deletePriceChangeHistoryById(@RequestParam Integer id){
        return priceChangeHistoryService.deletePriceChangeHistoryById(id);
    }
}
