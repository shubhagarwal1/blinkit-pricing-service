package com.blinkitclone.blinkitclone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "applied_coupon_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppliedCouponsHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;

    Integer userId;
    Long orderId;
    String couponId;
    Integer discountAmount;
    LocalDateTime appliedAt;
    Integer orderTotalAfterDiscount;
}
