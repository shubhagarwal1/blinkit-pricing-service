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
public class ProductPricingRequestDto {
  private Integer productId;
  private Integer basePrice;
  private Integer taxId;
  private Integer categoryId;
  private Integer taxAmount;
  private Integer finalPrice;
  private Integer slashPrice;
  private Integer priceRuleId;
  private LocalDate createdDate;


}
