package com.ibw.skylab.loyaltybackend.entities.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {

    private String address;

    private String manufactureDate;

    private String collectionName;

    private BigInteger rarityPercentage;


}
