package com.blinkitclone.blinkitclone.entity;

import com.blinkitclone.blinkitclone.Enums.ApplicableCategory;
import com.blinkitclone.blinkitclone.Enums.CouponStatus;
import com.blinkitclone.blinkitclone.Enums.DeletionStatus;
import com.blinkitclone.blinkitclone.Enums.DiscountType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "coupons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coupons extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "applicable_category")
    ApplicableCategory applicableCategory;

    @Column(name = "max_usage_per_user")
    Integer maxUsagePerUser;

    @Column(name = "max_usage")
    Integer maxUsage;

    @Column(name = "coupon_code")
    String couponCode;

    @Column(name = "start_date")
    LocalDate startDate;

    @Column(name = "end_date")
    LocalDate endDate;

    @Column(name = "applying_condition")
    String applyingCondition;

    @Column(name = "max_discount")
    Integer maxDiscount;

    @Column(name = "mov")
    Integer mov;

    @Column(name = "description")
    String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "discount_type")
    DiscountType discountType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    CouponStatus  status;

    @Column(name = "redeemed_count")
    Integer redeemedCount;

    @Column(name = "created_by_id")
    Integer createdById;

    @Enumerated(EnumType.STRING)
    @Column(name = "deletion_status")
    DeletionStatus deletionStatus;
}
