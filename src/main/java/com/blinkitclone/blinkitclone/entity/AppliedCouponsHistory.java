package com.blinkitclone.blinkitclone.entity;

import com.blinkitclone.blinkitclone.Enums.DeletionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "applied_coupon_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppliedCouponsHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;

    @Column(name = "user_id")
    Integer userId;

    @Column(name = "order_id", nullable = false, unique = true)
    Long orderId;

    @Column(name = "coupon_id")
    Integer couponId;

    @Column(name = "discount_amount")
    Integer discountAmount;

    @Column(name = "applied_at")
    LocalDateTime appliedAt;

    @Column(name = "order_total_after_discount")
    Integer orderTotalAfterDiscount;

    @Enumerated(EnumType.STRING)
    @Column(name = "deletion_status")
    DeletionStatus deletionStatus;
}
