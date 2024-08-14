package com.ibw.skylab.loyaltybackend.webAPI.controllers;

import com.ibw.skylab.loyaltybackend.business.abstracts.ProductService;
import com.ibw.skylab.loyaltybackend.core.utilities.results.DataResult;
import com.ibw.skylab.loyaltybackend.core.utilities.results.Result;
import com.ibw.skylab.loyaltybackend.entities.Product;
import com.ibw.skylab.loyaltybackend.entities.dtos.product.CreateProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<Result> addProduct(CreateProductDto createProductDto){
        var result = productService.addProduct(createProductDto);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<DataResult<List<Product>>> getAllProducts(){
        var result = productService.getAllProducts();

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getProductsByCompanyId/{companyId}")
    public ResponseEntity<DataResult<List<Product>>> getProductsByCompanyId(@PathVariable int companyId){
        var result = productService.getProductsByCompanyId(companyId);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getProductsByUserId/{productId}")
    public ResponseEntity<DataResult<List<Product>>> getProductsByUserId(@PathVariable int productId){
        var result = productService.getProductsByUserId(productId);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.badRequest().body(result);
    }



}
