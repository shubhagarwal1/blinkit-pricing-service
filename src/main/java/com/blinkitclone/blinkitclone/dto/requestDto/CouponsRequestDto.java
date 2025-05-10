package com.blinkitclone.blinkitclone.dto.requestDto;

import com.blinkitclone.blinkitclone.Enums.ApplicableCategory;
import com.blinkitclone.blinkitclone.Enums.CouponStatus;
import com.blinkitclone.blinkitclone.Enums.DiscountType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponsRequestDto {

    ApplicableCategory applicableCategory;
    Integer maxUsagePerUser;
    Integer maxUsage;
    String couponCode;
    LocalDate startDate;
    LocalDate endDate;
    String applyingCondition;
    Integer maxDiscount;
    Integer mov;
    String description;
    DiscountType discountType;
    CouponStatus status;
    Integer redeemedCount;
    Integer createdById;
}
