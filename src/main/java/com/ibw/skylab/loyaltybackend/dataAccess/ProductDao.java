package com.ibw.skylab.loyaltybackend.dataAccess;

import com.ibw.skylab.loyaltybackend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends JpaRepository<Product, Integer> {

    Optional<Product> findByCodeAndDeleted(String code, boolean deleted);

    Optional<Product> findByIdAndDeleted(Integer id, boolean deleted);

    Optional<List<Product>>findAllByDeleted(boolean deleted);

    Optional<List<Product>>findAllByCompanyIdAndDeleted(int companyId, boolean deleted);

    Optional<List<Product>>findAllByUserIdAndDeleted(int userId, boolean deleted);




}
