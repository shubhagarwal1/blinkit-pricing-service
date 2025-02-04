package com.blinkitclone.blinkitclone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "price_change_history")
public class PriceChangeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Long productId;
    Integer oldPrice;
    Integer newPrice;
    LocalDateTime changedAt;
    String reasonForChange;
}
