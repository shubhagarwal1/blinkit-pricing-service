package com.blinkitclone.blinkitclone.dto.responseDto;

import com.blinkitclone.blinkitclone.Enums.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CouponsResponseDto {

    private String error;
    private Category applicableCategory;
    private String couponCode;
    private LocalDate startDate;
    private LocalDate endDate;
    private String applyingCondition;
    private Integer maxDiscount;
    private Integer mov;
    private String description;
    private Integer discountPercentage;
}
