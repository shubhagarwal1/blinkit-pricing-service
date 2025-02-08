package com.blinkitclone.blinkitclone.controller.advice;
import com.blinkitclone.blinkitclone.exception.InvalidProductPricingException;
import com.blinkitclone.blinkitclone.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<String> handleProductNotFound(ProductNotFoundException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(InvalidProductPricingException.class)
  public ResponseEntity<String> handleInvalidProductPricing(InvalidProductPricingException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception ex) {
    return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
