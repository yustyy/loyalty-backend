package com.ibw.skylab.loyaltybackend.dataAccess;

import com.ibw.skylab.loyaltybackend.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyDao extends JpaRepository<Company, Integer> {

    Optional<Company> findByEmailAndDeleted(String email, boolean deleted);

    Optional<Company> findByIdAndDeleted(int id, boolean deleted);

    Optional<List<Company>> findAllByDeleted(boolean deleted);

}
