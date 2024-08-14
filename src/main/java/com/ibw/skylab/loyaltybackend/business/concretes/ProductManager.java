package com.ibw.skylab.loyaltybackend.business.concretes;

import com.ibw.skylab.loyaltybackend.business.abstracts.CompanyService;
import com.ibw.skylab.loyaltybackend.business.abstracts.ProductService;
import com.ibw.skylab.loyaltybackend.business.constants.ProductMessages;
import com.ibw.skylab.loyaltybackend.core.utilities.results.*;
import com.ibw.skylab.loyaltybackend.dataAccess.ProductDao;
import com.ibw.skylab.loyaltybackend.entities.Product;
import com.ibw.skylab.loyaltybackend.entities.dtos.product.CreateProductDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService {

    private final ProductDao productDao;

    private final ModelMapper modelMapper;

    private final CompanyService companyService;


    @Override
    public Result addProduct(CreateProductDto createProductDto) {

        if (createProductDto.getName().isEmpty()){
            return new ErrorResult(ProductMessages.productNameCannotBeEmpty);
        }

        if (createProductDto.getDescription().isEmpty()){
            return new ErrorResult(ProductMessages.productDescriptionCannotBeEmpty);
        }

        /*
        if (createProductDto.getCategoryIds().isEmpty()){
            return new ErrorResult(ProductMessages.productCategoryCannotBeEmpty);
        }

         */

        var companyResult = companyService.getCompanyById(createProductDto.getCompanyId());

        if (!companyResult.isSuccess()){
           return companyResult;
        }

        Product product = Product.builder()
                .name(createProductDto.getName())
                .description(createProductDto.getDescription())
                .company(companyResult.getData())
                .code(generateCode())
                .build();

        //nft address

        productDao.save(product);

        return new SuccessResult(ProductMessages.productAdded);


    }

    @Override
    public DataResult<List<Product>> getAllProducts() {
        var result = productDao.findAllByDeleted(false);

        if (result.isEmpty()){
            return new ErrorDataResult<>(ProductMessages.productsNotFound);
        }

        return new SuccessDataResult<>(result.get(), ProductMessages.productsListed);
    }

    @Override
    public DataResult<Product> getProductById(int id) {
        var result = productDao.findByIdAndDeleted(id, false);

        if (!result.isPresent()){
            return new ErrorDataResult<>(ProductMessages.productNotFound);
        }

        return new SuccessDataResult<>(result.get(), ProductMessages.productsListed);
    }

    @Override
    public DataResult<List<Product>> getProductsByCompanyId(int companyId) {
        var result = productDao.findAllByCompanyIdAndDeleted(companyId, false);

        if (!result.isPresent()){
            return new ErrorDataResult<>(ProductMessages.productsNotFound);
        }

        return new SuccessDataResult<>(result.get(), ProductMessages.productsListed);
    }

    @Override
    public DataResult<List<Product>> getProductsByUserId(int userId) {
        var result = productDao.findAllByUserIdAndDeleted(userId, false);

        if (!result.isPresent()){
            return new ErrorDataResult<>(ProductMessages.productsNotFound);
        }

        return new SuccessDataResult<>(result.get(), ProductMessages.productsListed);
    }

    private String generateCode() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[64];
        secureRandom.nextBytes(randomBytes);
        return Base64.getUrlEncoder().encodeToString(randomBytes);
    }
}
