package com.blinkitclone.blinkitclone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "product_pricing")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPricing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productPriceId;

    Integer productId;

    Integer basePrice;

    Integer taxId;

    Integer categoryId;

    Integer taxAmount;

    Integer finalPrice;

    Integer slashPrice;

    Integer priceRuleId;

    LocalDate createdDate;

    LocalDate updatedDate;


    @Override
    public String toString() {
        return "ProductPricing{" +
            "productPriceId=" + productPriceId +
            ", basePrice=" + basePrice +
            ", categoryId=" + categoryId +
            ", createdDate=" + createdDate +
            ", finalPrice=" + finalPrice +
            ", priceRuleId=" + priceRuleId +
            ", productId=" + productId +
            ", slashPrice=" + slashPrice +
            ", taxAmount=" + taxAmount +
            ", taxId=" + taxId +
            ", updatedDate=" + updatedDate +
            '}';
    }

}
