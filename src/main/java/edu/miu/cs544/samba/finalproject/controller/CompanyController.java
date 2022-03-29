package edu.miu.cs544.samba.finalproject.controller;

import edu.miu.cs544.samba.finalproject.entity.Company;
import edu.miu.cs544.samba.finalproject.service.CompanyService;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CompanyController {

    @Autowired
    private CompanyService companyManager;

    @GetMapping("/companies")
    public List<Company> all() {
        return companyManager.getAllCompanies();
    }

    @GetMapping("/companies/{id}")
    public Company one(@PathVariable Long id) {
        return companyManager.getOneCompany(id);
    }

    @PostMapping("/companies")
    public SuccessResponse newCompany(@RequestBody Company company) {
        return companyManager.createCompany(company);
    }

    @PutMapping("/companies/{id}")
    public SuccessResponse updateCompany(@RequestBody Company company, @PathVariable Long id) {
        return companyManager.updateCompany(company,id);
    }

    @DeleteMapping("/companies/{id}")
    public SuccessResponse deleteJob(@PathVariable Long id) {
        return companyManager.deleteCompany(id);
    }
}
