package com.blinkitclone.blinkitclone.entity;

import com.blinkitclone.blinkitclone.Enums.Category;
import com.blinkitclone.blinkitclone.Enums.CouponStatus;
import com.blinkitclone.blinkitclone.Enums.DeletionStatus;
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
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "applicable_category")
    private Category applicableCategory;

    @Column(name = "max_usage_per_user")
    private Integer maxUsagePerUser;

    @Column(name = "max_usage")
    private Integer maxUsage;

    @Column(name = "coupon_code")
    private String couponCode;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "applying_condition")
    private String applyingCondition;

    @Column(name = "max_discount")
    private Integer maxDiscount;

    @Column(name = "mov")
    private Integer mov;

    @Column(name = "description")
    private String description;

    @Column(name = "discount_percentage")
    private Integer discountPercentage;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CouponStatus status;

    @Column(name = "redeemed_count")
    private Integer redeemedCount;

    @Column(name = "created_by_id")
    private Integer createdById;

    @Enumerated(EnumType.STRING)
    @Column(name = "deletion_status")
    private DeletionStatus deletionStatus;
}
