package com.ibw.skylab.loyaltybackend.webAPI.controllers;

import com.ibw.skylab.loyaltybackend.business.abstracts.CompanyService;
import com.ibw.skylab.loyaltybackend.core.utilities.results.Result;
import com.ibw.skylab.loyaltybackend.entities.dtos.company.CreateCompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @PostMapping("/addCompany")
    public ResponseEntity<Result> addCompany(@RequestBody CreateCompanyDto createCompanyDto){
        var result = companyService.addCompany(createCompanyDto);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getCompanyById/{companyId}")
    public ResponseEntity<Result> getCompanyById(@PathVariable int companyId){
        var result = companyService.getCompanyById(companyId);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllCompanies")
    public ResponseEntity<Result> getAllCompanies(){
        var result = companyService.getAllCompanies();

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.badRequest().body(result);
    }


}
