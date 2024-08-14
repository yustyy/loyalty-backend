package com.ibw.skylab.loyaltybackend.business.abstracts;

import com.ibw.skylab.loyaltybackend.core.utilities.results.DataResult;
import com.ibw.skylab.loyaltybackend.core.utilities.results.Result;
import com.ibw.skylab.loyaltybackend.entities.Company;
import com.ibw.skylab.loyaltybackend.entities.dtos.company.CreateCompanyDto;

import java.util.List;

public interface CompanyService {

    Result addCompany(CreateCompanyDto createCompanyDto);

    DataResult<Company> getCompanyById(int companyId);

    DataResult<List<Company>> getAllCompanies();

}
