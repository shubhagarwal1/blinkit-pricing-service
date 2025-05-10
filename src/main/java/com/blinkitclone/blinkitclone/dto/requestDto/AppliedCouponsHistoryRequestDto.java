package com.blinkitclone.blinkitclone.dto.requestDto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppliedCouponsHistoryRequestDto {
    Integer userId;
    Long orderId;
    Integer couponId;
    Integer discountAmount;
    LocalDateTime appliedAt;
    Integer orderTotalAfterDiscount;
}
