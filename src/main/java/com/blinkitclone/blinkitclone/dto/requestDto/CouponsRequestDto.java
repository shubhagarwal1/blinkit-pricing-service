package com.blinkitclone.blinkitclone.dto.requestDto;

import com.blinkitclone.blinkitclone.Enums.Category;
import com.blinkitclone.blinkitclone.Enums.CouponStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponsRequestDto {


    private Category applicableCategory;
    private Integer maxUsagePerUser;
    private Integer maxUsage;
    private String couponCode;
    private LocalDate startDate;
    private LocalDate endDate;
    private String applyingCondition;
    private Integer maxDiscount;
    private Integer mov;
    private String description;
    private Integer discountPercentage;
    private CouponStatus status;
    private Integer redeemedCount;
    private Integer createdById;
}
