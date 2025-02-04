package com.blinkitclone.blinkitclone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "taxation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Taxation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer categoryId;

    Integer TaxPercentage;

    LocalDate createdDate;

    LocalDate updatedDate;
}
