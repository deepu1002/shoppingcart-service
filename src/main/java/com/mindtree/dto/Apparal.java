package com.mindtree.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorColumn(name = "Apparal", discriminatorType = DiscriminatorType.STRING)
public class Apparal extends Product {
    private String type;
    private String brand;
    private String design;

}
