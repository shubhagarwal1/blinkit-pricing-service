package com.blinkitclone.blinkitclone.dto.responseDto;

import com.blinkitclone.blinkitclone.Enums.ApplicableCategory;
import com.blinkitclone.blinkitclone.Enums.CouponStatus;
import com.blinkitclone.blinkitclone.Enums.DeletionStatus;
import com.blinkitclone.blinkitclone.Enums.DiscountType;
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

    String error;
    ApplicableCategory applicableCategory;
    String couponCode;
    LocalDate startDate;
    LocalDate endDate;
    String applyingCondition;
    Integer maxDiscount;
    Integer mov;
    String description;
    DiscountType discountType;
}
