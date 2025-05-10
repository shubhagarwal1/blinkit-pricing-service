package com.blinkitclone.blinkitclone.dto.responseDto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaxationResponseDto {

  private Integer id;
  private Integer categoryId;
  private Integer taxPercentage;
  private LocalDate createdDate;
  private LocalDate updatedDate;
  private String status;
  private String message;

  public TaxationResponseDto(Integer id, Integer categoryId, Integer taxPercentage, LocalDate createdDate, LocalDate updatedDate) {
    this.id = id;
    this.categoryId = categoryId;
    this.taxPercentage = taxPercentage;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  public TaxationResponseDto(String status, String message) {
    this.status = status;
    this.message = message;
  }

  // Getters and Setters (if not using Lombok)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Integer getTaxPercentage() {
    return taxPercentage;
  }

  public void setTaxPercentage(Integer taxPercentage) {
    this.taxPercentage = taxPercentage;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  public LocalDate getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(LocalDate updatedDate) {
    this.updatedDate = updatedDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


}
