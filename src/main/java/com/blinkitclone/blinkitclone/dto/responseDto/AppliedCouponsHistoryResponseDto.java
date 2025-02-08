package com.blinkitclone.blinkitclone.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder

public class AppliedCouponsHistoryResponseDto {
    String Error;
    Integer userId;
    Long orderId;
    Integer couponId;
    Integer discountAmount;
    LocalDateTime appliedAt;
    Integer orderTotalAfterDiscount;
}
