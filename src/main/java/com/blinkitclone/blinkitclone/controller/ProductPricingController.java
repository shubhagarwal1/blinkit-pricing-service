package com.blinkitclone.blinkitclone.controller;

import com.blinkitclone.blinkitclone.dto.requestDto.ProductPricingRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.ProductPricingResponseDto;
import com.blinkitclone.blinkitclone.service.ProductPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/productPricing")
public class ProductPricingController {

    @Autowired
    private ProductPricingService productPricingService;

    @PostMapping("/create")
    public ProductPricingResponseDto createProductPricing(@RequestBody ProductPricingRequestDto productPricingRequestDto){
        return productPricingService.createProductPricing(productPricingRequestDto);
    }

    @GetMapping("/getById")
    public ProductPricingResponseDto getProductPricingById(@RequestParam Integer id){
        return productPricingService.getProductPricingById(id);
    }

    @PatchMapping("/updateById")
    public ProductPricingResponseDto updateProductPricingById(@RequestParam Integer id){
        return productPricingService.updateProductPricingById(id);
    }

    @DeleteMapping("/deleteById")
    public ProductPricingResponseDto deleteProductPricingById(@RequestParam Integer id){
        return productPricingService.deleteProductPricingById(id);
    }
}
