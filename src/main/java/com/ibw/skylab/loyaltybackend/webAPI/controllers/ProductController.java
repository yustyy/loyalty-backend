package com.ibw.skylab.loyaltybackend.webAPI.controllers;

import com.ibw.skylab.loyaltybackend.business.abstracts.ProductService;
import com.ibw.skylab.loyaltybackend.entities.dtos.product.CreateProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

}
