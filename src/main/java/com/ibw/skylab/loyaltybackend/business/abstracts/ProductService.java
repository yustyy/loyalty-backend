package com.ibw.skylab.loyaltybackend.business.abstracts;

import com.ibw.skylab.loyaltybackend.core.utilities.results.DataResult;
import com.ibw.skylab.loyaltybackend.core.utilities.results.Result;
import com.ibw.skylab.loyaltybackend.entities.Product;
import com.ibw.skylab.loyaltybackend.entities.dtos.product.CreateProductDto;

import java.util.List;

public interface ProductService {


    Result addProduct(CreateProductDto createProductDto);

    DataResult<List<Product>> getAllProducts();

    DataResult<Product> getProductById(int id);

    DataResult<List<Product>> getProductsByCompanyId(int companyId);

    DataResult<List<Product>> getProductsByUserId(int userId);
}
