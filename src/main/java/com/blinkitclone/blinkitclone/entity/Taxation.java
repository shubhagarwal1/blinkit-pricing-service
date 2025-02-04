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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and Setter for 'categoryId'
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    // Getter and Setter for 'taxPercentage'
    public Integer getTaxPercentage() {
        return TaxPercentage;
    }

    public void setTaxPercentage(Integer taxPercentage) {
        this.TaxPercentage = taxPercentage;
    }

    // Getter and Setter for 'createdDate'
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    // Getter and Setter for 'updatedDate'
    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

}
