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
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "order_id", nullable = false, unique = true)
    private Long orderId;

    @Column(name = "coupon_id")
    private Integer couponId;

    @Column(name = "discount_amount")
    private Integer discountAmount;

    @Column(name = "applied_at")
    private LocalDateTime appliedAt;

    @Column(name = "order_total_after_discount")
    private Integer orderTotalAfterDiscount;

    @Enumerated(EnumType.STRING)
    @Column(name = "deletion_status")
    private DeletionStatus deletionStatus;
}
