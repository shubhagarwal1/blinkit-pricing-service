package com.blinkitclone.blinkitclone.controller;

import com.blinkitclone.blinkitclone.dto.requestDto.TaxationRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.TaxationResponseDto;
import com.blinkitclone.blinkitclone.entity.Taxation;
import com.blinkitclone.blinkitclone.exception.TaxationNotFoundException;
import com.blinkitclone.blinkitclone.service.TaxationService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/taxation")
public class TaxationController {

    @Autowired
    private TaxationService taxationService;

    @PostMapping("/create")
    public ResponseEntity<TaxationResponseDto> createTaxation(@RequestBody TaxationRequestDto taxationRequestDto){
        try {
            TaxationResponseDto response = taxationService.createTaxation(taxationRequestDto);

            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new TaxationResponseDto("Error", e.getMessage()), HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>(new TaxationResponseDto("Error", "Error occurred while creating taxation: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<TaxationResponseDto> getTaxationById(@RequestParam Integer id){
        try {
            TaxationResponseDto response = taxationService.getTaxationById(id);

            if ("Error".equals(response.getStatus())) {
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                new TaxationResponseDto("Error", "An unexpected error occurred."),
                HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

    @PatchMapping("/updateById")
    public ResponseEntity<TaxationResponseDto> updateTaxationById(@RequestParam Integer id, @RequestBody TaxationRequestDto taxationRequestDto) {
        try {
            TaxationResponseDto response = taxationService.updateTaxationById(id, taxationRequestDto);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TaxationNotFoundException e) {
            return new ResponseEntity<>(new TaxationResponseDto("Error", e.getMessage()), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(new TaxationResponseDto("Error", "Error occurred while updating taxation: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<TaxationResponseDto> deleteTaxationById(@RequestParam Integer id) {
        try {
            TaxationResponseDto response = taxationService.deleteTaxationById(id);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TaxationNotFoundException e) {
            return new ResponseEntity<>(new TaxationResponseDto("Error", e.getMessage()), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(new TaxationResponseDto("Error", "An error occurred: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
