package com.blinkitclone.blinkitclone.service;

import com.blinkitclone.blinkitclone.dto.requestDto.TaxationRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.TaxationResponseDto;
import com.blinkitclone.blinkitclone.entity.Taxation;
import com.blinkitclone.blinkitclone.exception.TaxationNotFoundException;
import com.blinkitclone.blinkitclone.repo.TaxationRepo;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxationService {

    @Autowired
    private TaxationRepo taxationRepo;


    public TaxationResponseDto createTaxation(TaxationRequestDto taxationRequestDto) {
        try {
            if (taxationRequestDto.getCategoryId() == null || taxationRequestDto.getTaxPercentage() == null) {
                throw new IllegalArgumentException("Category ID and Tax Percentage must be provided");
            }

            Taxation taxation = new Taxation();
            taxation.setCategoryId(taxationRequestDto.getCategoryId());
            taxation.setTaxPercentage(taxationRequestDto.getTaxPercentage());
            taxation.setCreatedDate(LocalDate.now());
            taxation.setUpdatedDate(LocalDate.now());

            Taxation savedTaxation = taxationRepo.save(taxation);

            return new TaxationResponseDto(
                savedTaxation.getId(),
                savedTaxation.getCategoryId(),
                savedTaxation.getTaxPercentage(),
                savedTaxation.getCreatedDate(),
                savedTaxation.getUpdatedDate()
            );

        } catch (Exception e) {
            throw new RuntimeException("Error occurred while creating taxation: " + e.getMessage());
        }
    }

    public TaxationResponseDto getTaxationById(Integer id) {
        try {
            Optional<Taxation> taxationOptional = taxationRepo.findById(id);

            if (taxationOptional.isEmpty()) {
                return new TaxationResponseDto("Error", "Taxation record not found for ID: " + id);
            }

            Taxation taxation = taxationOptional.get();

            TaxationResponseDto response = new TaxationResponseDto(
                taxation.getId(),
                taxation.getCategoryId(),
                taxation.getTaxPercentage(),
                taxation.getCreatedDate(),
                taxation.getUpdatedDate()
            );
            response.setStatus("Success");
            response.setMessage("Taxation record fetched successfully.");

            return response;
        } catch (Exception e) {
            return new TaxationResponseDto("Error", "An unexpected error occurred while fetching taxation: " + e.getMessage());
        }
    }

    public TaxationResponseDto updateTaxationById(Integer id, TaxationRequestDto taxationRequestDto) {
        try {
            Optional<Taxation> taxationOptional = taxationRepo.findById(id);

            if (taxationOptional.isEmpty()) {
                throw new TaxationNotFoundException("Taxation record not found for ID: " + id);
            }

            if (taxationRequestDto.getCategoryId() == null || taxationRequestDto.getTaxPercentage() == null) {
                throw new IllegalArgumentException("Category ID and Tax Percentage must be provided");
            }

            Taxation taxation = taxationOptional.get();
            taxation.setCategoryId(taxationRequestDto.getCategoryId());
            taxation.setTaxPercentage(taxationRequestDto.getTaxPercentage());
            taxation.setUpdatedDate(LocalDate.now());

            Taxation updatedTaxation = taxationRepo.save(taxation);

            return new TaxationResponseDto(
                updatedTaxation.getId(),
                updatedTaxation.getCategoryId(),
                updatedTaxation.getTaxPercentage(),
                updatedTaxation.getCreatedDate(),
                updatedTaxation.getUpdatedDate()
            );

        } catch (TaxationNotFoundException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while updating taxation: " + e.getMessage());
        }
    }

    public TaxationResponseDto deleteTaxationById(Integer id) {
        Optional<Taxation> taxationOptional = taxationRepo.findById(id);

        if (taxationOptional.isPresent()) {
            taxationRepo.deleteById(id);
            return new TaxationResponseDto("Success", "Taxation record deleted successfully for ID: " + id);
        } else {
            throw new TaxationNotFoundException("Taxation record not found for ID: " + id);
        }
    }
}
