package com.ibw.skylab.loyaltybackend.business.concretes;

import com.ibw.skylab.loyaltybackend.business.abstracts.CompanyService;
import com.ibw.skylab.loyaltybackend.business.constants.CompanyMessages;
import com.ibw.skylab.loyaltybackend.core.utilities.results.*;
import com.ibw.skylab.loyaltybackend.dataAccess.CompanyDao;
import com.ibw.skylab.loyaltybackend.entities.Company;
import com.ibw.skylab.loyaltybackend.entities.CorporateCompany;
import com.ibw.skylab.loyaltybackend.entities.IndividualCompany;
import com.ibw.skylab.loyaltybackend.entities.dtos.company.CreateCompanyDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CompanyManager implements CompanyService {

    private final CompanyDao companyDao;

    private final ModelMapper modelMapper;

    @Override
    public Result addCompany(CreateCompanyDto createCompanyDto) {

        if(createCompanyDto.getEmail().isEmpty()){
            return new ErrorResult(CompanyMessages.emailCannotBeEmpty);
        }

        if (createCompanyDto.getPhoneNumber().isEmpty()){
            return new ErrorResult(CompanyMessages.phoneNumberCannotBeEmpty);
        }

        if (createCompanyDto.getAddress().isEmpty()){
            return new ErrorResult(CompanyMessages.addressCannotBeEmpty);
        }

        if (createCompanyDto.getIndustry().isEmpty()){
            return new ErrorResult(CompanyMessages.industryCannotBeEmpty);
        }


        if (createCompanyDto.getCompanyType().equals("INDIVIDUAL")){

            if (createCompanyDto.getFirstName().isEmpty()){
                return new ErrorResult(CompanyMessages.firstNameCannotBeEmpty);
            }

            if (createCompanyDto.getLastName().isEmpty()){
                return new ErrorResult(CompanyMessages.lastNameCannotBeEmpty);
            }

            if (createCompanyDto.getBirthDate().isEmpty()){
                return new ErrorResult(CompanyMessages.birthDateCannotBeEmpty);
            }

            IndividualCompany company = modelMapper.map(createCompanyDto, IndividualCompany.class);

            company.setCreatedDate(new Date());
            companyDao.save(company);

            return new SuccessResult(CompanyMessages.companyAdded);

        }
        else if (createCompanyDto.getCompanyType().equals("CORPORATE")){


            if (createCompanyDto.getTaxNumber().isEmpty()){
                return new ErrorResult(CompanyMessages.taxNumberCannotBeEmpty);
            }

            if (createCompanyDto.getCompanyName().isEmpty()){
                return new ErrorResult(CompanyMessages.companyNameCannotBeEmpty);
            }

            if (createCompanyDto.getRegistrationDate().isEmpty()){
                return new ErrorResult(CompanyMessages.registrationDateCannotBeEmpty);
            }

            if (createCompanyDto.getContactPersonFirstName().isEmpty()){
                return new ErrorResult(CompanyMessages.firstNameCannotBeEmpty);
            }

            //more business rules can be added here i got bored

            CorporateCompany company = modelMapper.map(createCompanyDto, CorporateCompany.class);

            company.setCreatedDate(new Date());
            companyDao.save(company);

            return new SuccessResult(CompanyMessages.companyAdded);


        }

        return new ErrorResult(CompanyMessages.companyTypeCannotBeEmpty);
    }

    @Override
    public DataResult<Company> getCompanyById(int companyId) {
        var result = companyDao.findByIdAndDeleted(companyId, false);

        if (!result.isPresent()){
            return new ErrorDataResult<>(CompanyMessages.companyNotFound);
        }

        return new SuccessDataResult<>(result.get(), CompanyMessages.companyFound);
    }
}
