package com.blinkitclone.blinkitclone.service;

import com.blinkitclone.blinkitclone.dto.requestDto.ProductPricingRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.ProductPricingResponseDto;
import com.blinkitclone.blinkitclone.repo.ProductPricingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPricingService {

    @Autowired
    private ProductPricingRepo productPricingRepo;


    public ProductPricingResponseDto createProductPricing(ProductPricingRequestDto productPricingRequestDto) {
        return new ProductPricingResponseDto();
    }

    public ProductPricingResponseDto getProductPricingById(Integer id) {
        return new ProductPricingResponseDto();
    }

    public ProductPricingResponseDto updateProductPricingById(Integer id) {
        return new ProductPricingResponseDto();

    }

    public ProductPricingResponseDto deleteProductPricingById(Integer id) {
        return new ProductPricingResponseDto();

    }
}
