package com.ibw.skylab.loyaltybackend.entities.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {

    private String name;

    private String description;

    private int companyId;

    private List<Integer> categoryIds;

}
