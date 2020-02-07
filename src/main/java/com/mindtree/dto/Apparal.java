package com.mindtree.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorColumn(name = "Apparal", discriminatorType = DiscriminatorType.STRING)
public class Apparal extends Product {

    @Column(name = "TYPE")
    private String type;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "DESIGN")
    private String design;

    public Apparal(String category, String name, float price, String type, String brand, String design) {
        this.setCategory(category);
        this.setName(name);
        this.setPrice(price);
        this.setType(type);
        this.setBrand(brand);
        this.setDesign(design);
    }

    @Override
    public String toString() {
        return "Apparal{" + "type='" + type + '\'' + ", brand='" + brand + '\'' + ", design='" + design + '\'' + '}';
    }
}
