package com.ibw.skylab.loyaltybackend.entities.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetProductDto {

    private String qrCodeUrl;

    private String name;

}
