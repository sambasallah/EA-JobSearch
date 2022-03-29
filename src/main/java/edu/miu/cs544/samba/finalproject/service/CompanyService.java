package edu.miu.cs544.samba.finalproject.service;

import edu.miu.cs544.samba.finalproject.entity.Company;
import edu.miu.cs544.samba.finalproject.exception.ResourceNotFoundException;
import edu.miu.cs544.samba.finalproject.repository.CompanyRepository;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.util.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public SuccessResponse createCompany(Company company) {
        companyRepository.save(company);
        return UtilFunctions.handleSuccessResponse(true, "Company Created!");
    }


    public Company getOneCompany(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> {
            return UtilFunctions.handleResourceNotFoundException("Company with id " + id + " not found!");
        });

    }

    public SuccessResponse updateCompany(Company company, Long id) {
        Company companyToUpdate = getOneCompany(id);
        companyToUpdate.setAddress(company.getAddress());
        companyToUpdate.setJobs(company.getJobs());
        companyToUpdate.setName(company.getName());

        companyRepository.save(companyToUpdate);

        return UtilFunctions.handleSuccessResponse(true, "Company Updated!");

    }

    public SuccessResponse updateCompany(Company company) {

        companyRepository.save(company);

        return UtilFunctions.handleSuccessResponse(true, "Company Updated!");

    }

    public SuccessResponse deleteCompany(Long id) {
        Company company = getOneCompany(id);
        companyRepository.delete(company);
        return UtilFunctions.handleSuccessResponse(true, "Job with id " + id + " deleted!");
    }
}


