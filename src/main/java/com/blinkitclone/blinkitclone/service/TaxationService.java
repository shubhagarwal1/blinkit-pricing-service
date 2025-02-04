package com.blinkitclone.blinkitclone.service;

import com.blinkitclone.blinkitclone.dto.requestDto.TaxationRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.TaxationResponseDto;
import com.blinkitclone.blinkitclone.repo.TaxationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxationService {

    @Autowired
    private TaxationRepo taxationRepo;


    public TaxationResponseDto createTaxation(TaxationRequestDto taxationRequestDto) {
        return new TaxationResponseDto();
    }

    public TaxationResponseDto getTaxationById(Integer id) {
        return new TaxationResponseDto();
    }

    public TaxationResponseDto updateTaxationById(Integer id) {
        return new TaxationResponseDto();
    }

    public TaxationResponseDto deleteTaxationById(Integer id) {
        return new TaxationResponseDto();
    }
}
