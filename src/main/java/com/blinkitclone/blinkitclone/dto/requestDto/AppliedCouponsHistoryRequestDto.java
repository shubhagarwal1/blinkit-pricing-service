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
    private Integer userId;

    private Long orderId;

    private Integer couponId;

    private Integer discountAmount;

    private LocalDateTime appliedAt;

    private Integer orderTotalAfterDiscount;
}
