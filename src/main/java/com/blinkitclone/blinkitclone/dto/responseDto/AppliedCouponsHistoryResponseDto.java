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
    private String error;
    private Integer userId;
    private Long orderId;
    private Integer couponId;
    private Integer discountAmount;
    private LocalDateTime appliedAt;
    private Integer orderTotalAfterDiscount;
}
