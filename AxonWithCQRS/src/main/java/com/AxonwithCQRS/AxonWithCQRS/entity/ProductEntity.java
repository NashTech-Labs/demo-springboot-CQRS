package com.AxonwithCQRS.AxonWithCQRS.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class ProductEntity {
    @Id
    private String id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
