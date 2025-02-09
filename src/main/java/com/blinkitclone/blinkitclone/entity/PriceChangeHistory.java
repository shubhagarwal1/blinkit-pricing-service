package com.blinkitclone.blinkitclone.entity;

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
    Integer id;

    @Column(name = "product_id")
    Long productId;

    @Column(name = "old_price")
    Integer oldPrice;

    @Column(name = "new_Price")
    Integer newPrice;

    @Column(name = "changed_at")
    LocalDateTime changedAt;

    @Column(name = "reason_for_change")
    String reasonForChange;

    @Enumerated(EnumType.STRING)
    @Column(name = "deletion_status")
    DeletionStatus deletionStatus;
}
