package com.blinkitclone.blinkitclone.entity;

import com.blinkitclone.blinkitclone.Enums.Category;
import com.blinkitclone.blinkitclone.Enums.DeletionStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "price_change_history")
@Builder
public class PriceChangeHistory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "changed_at")
    private LocalDateTime changedAt;

    @Column(name = "reason_for_change")
    private String reasonForChange;

    @Column(name = "min_price")
    private Integer minPrice;

    @Column(name = "max_price")
    private Integer maxPrice;

    @Column(name = "merchant_price")
    private Integer merchantPrice;

    @Column(name = "amount_with_commission_and_without_tax")
    private Integer amountWithCommissionAndWithoutTax;

    @Column(name = "price_after_discount")
    private Integer priceAfterDiscount;

    @Column(name = "tax_id")
    private Integer taxId;

    @Column(name = "final_price")
    private Integer finalPrice;

    @Column(name = "slasher_price")
    private Integer slasherPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

}
