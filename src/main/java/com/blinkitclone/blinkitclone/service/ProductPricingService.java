package com.blinkitclone.blinkitclone.service;

import com.blinkitclone.blinkitclone.dto.requestDto.ProductPricingRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.ProductPricingResponseDto;
import com.blinkitclone.blinkitclone.entity.ProductPricing;
import com.blinkitclone.blinkitclone.exception.InvalidProductPricingException;
import com.blinkitclone.blinkitclone.exception.ProductNotFoundException;
import com.blinkitclone.blinkitclone.repo.ProductPricingRepo;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPricingService {

    @Autowired
    private ProductPricingRepo productPricingRepo;

    @Transactional
    private ProductPricingResponseDto mapToResponseDto(ProductPricing productPricing) {
        return new ProductPricingResponseDto(
            productPricing.getProductPriceId(),
            productPricing.getProductId(),
            productPricing.getBasePrice(),
            productPricing.getTaxId(),
            productPricing.getCategoryId(),
            productPricing.getTaxAmount(),
            productPricing.getFinalPrice(),
            productPricing.getSlashPrice(),
            productPricing.getPriceRuleId(),
            productPricing.getCreatedDate(),
            productPricing.getUpdatedDate()
        );
    }

    @Transactional
    public ProductPricingResponseDto createProductPricing(ProductPricingRequestDto productPricingRequestDto) {
        try {
            if (productPricingRequestDto == null) {
                throw new InvalidProductPricingException("Pricing data cannot be null");
            }

            System.out.println("Received ProductPricingRequestDto: " + productPricingRequestDto);

            ProductPricing productPricing = new ProductPricing(
                null,
                productPricingRequestDto.getProductId(),
                productPricingRequestDto.getBasePrice(),
                productPricingRequestDto.getTaxId(),
                productPricingRequestDto.getCategoryId(),
                productPricingRequestDto.getTaxAmount(),
                productPricingRequestDto.getFinalPrice(),
                productPricingRequestDto.getSlashPrice(),
                productPricingRequestDto.getPriceRuleId(),
                productPricingRequestDto.getCreatedDate(),
                LocalDate.now()
            );

            System.out.println("Entity to be saved: " + productPricing);

            ProductPricing savedProductPricing = productPricingRepo.save(productPricing);

            System.out.println("Saved ProductPricing: " + savedProductPricing);

            return mapToResponseDto(savedProductPricing);
        } catch (Exception ex) {
            System.err.println("Error occurred while creating product pricing: " + ex.getMessage());
            throw new InvalidProductPricingException("An error occurred while creating product pricing: " + ex.getMessage());
        }
    }

    @Transactional
    public ProductPricingResponseDto getProductPricingById(Integer id) {
        try {
            if (id == null || id <= 0) {
                throw new ProductNotFoundException("Product pricing with the given ID not found.");
            }

            Optional<ProductPricing> productPricingOptional = productPricingRepo.findById(id);
            if (productPricingOptional.isEmpty()) {
                throw new ProductNotFoundException("Product pricing not found for ID " + id);
            }

            return mapToResponseDto(productPricingOptional.get());
        } catch (ProductNotFoundException ex) {

            throw ex;
        } catch (Exception ex) {

            System.err.println("Error occurred while fetching product pricing: " + ex.getMessage());
            throw new RuntimeException("An error occurred while fetching product pricing: " + ex.getMessage());
        }
    }

    @Transactional
    public ProductPricingResponseDto updateProductPricingById(Integer id) {
        try {
            if (id == null || id <= 0) {
                throw new ProductNotFoundException("Product pricing with the given ID not found.");
            }

            Optional<ProductPricing> productPricingOptional = productPricingRepo.findById(id);
            if (productPricingOptional.isEmpty()) {
                throw new ProductNotFoundException("Product pricing not found for ID " + id);
            }

            ProductPricing productPricing = productPricingOptional.get();

            productPricing.setBasePrice(1000);
            productPricing.setTaxAmount(50);
            productPricing.setFinalPrice(productPricing.getBasePrice() + productPricing.getTaxAmount());
            productPricing.setUpdatedDate(LocalDate.now());

            ProductPricing updatedProductPricing = productPricingRepo.save(productPricing);

            return mapToResponseDto(updatedProductPricing);
        } catch (Exception ex) {

            System.err.println("Error occurred while updating product pricing: " + ex.getMessage());

            throw new RuntimeException("An error occurred while updating product pricing: " + ex.getMessage());
        }

    }

    @Transactional
    public ProductPricingResponseDto deleteProductPricingById(Integer id) {
        try {
            if (id == null || id <= 0) {
                throw new ProductNotFoundException("Product pricing with the given ID not found.");
            }

            Optional<ProductPricing> productPricingOptional = productPricingRepo.findById(id);
            if (productPricingOptional.isEmpty()) {
                throw new ProductNotFoundException("Product pricing not found for ID " + id);
            }

            productPricingRepo.deleteById(id);

            ProductPricing deletedProductPricing = productPricingOptional.get();
            return mapToResponseDto(deletedProductPricing);

        } catch (ProductNotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            System.err.println("Error occurred while deleting product pricing: " + ex.getMessage());
            throw new RuntimeException("An error occurred while deleting product pricing: " + ex.getMessage());
        }

    }
}
