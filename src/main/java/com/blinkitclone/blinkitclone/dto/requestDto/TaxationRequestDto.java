package com.blinkitclone.blinkitclone.dto.requestDto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaxationRequestDto {

  private Integer categoryId;
  private Integer taxPercentage;
  private LocalDate createdDate;
  private LocalDate updatedDate;


  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  // Getter and Setter for taxPercentage
  public Integer getTaxPercentage() {
    return taxPercentage;
  }

  public void setTaxPercentage(Integer taxPercentage) {
    this.taxPercentage = taxPercentage;
  }

  // Getter and Setter for createdDate
  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  // Getter and Setter for updatedDate
  public LocalDate getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(LocalDate updatedDate) {
    this.updatedDate = updatedDate;
  }

}
