package com.blinkitclone.blinkitclone.entity;

import com.blinkitclone.blinkitclone.Enums.CouponStatus;
import com.blinkitclone.blinkitclone.Enums.applicableCategory;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "coupons")
public class Coupons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    applicableCategory applicableCategory;

    Integer maxUsagePerUser;

    Integer maxUsage;

    String couponCode;

    LocalDate startDate;

    LocalDate endDate;

    String applyingCondition;

    Integer maxDiscount;

    Integer mov;

    LocalDate createdDate;
    LocalDate updatedDate;
    String description;
    String discountType;
    CouponStatus  status;
    Integer redeemedCount;
    String createdBy;
}
