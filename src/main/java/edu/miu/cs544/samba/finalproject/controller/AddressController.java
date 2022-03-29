package edu.miu.cs544.samba.finalproject.controller;

import edu.miu.cs544.samba.finalproject.entity.Address;
import edu.miu.cs544.samba.finalproject.entity.Application;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.service.AddressService;
import edu.miu.cs544.samba.finalproject.service.ApplicationService;
import edu.miu.cs544.samba.finalproject.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies/{id}/address")
    public Address getCompanyAddress(@PathVariable Long id) {
        return companyService.getOneCompany(id).getAddress();
    }

    @PostMapping("/companies/{id}/address")
    public SuccessResponse newAddress(@RequestBody Address address, @PathVariable Long id) {
        companyService.getOneCompany(id).setAddress(address);
        return  companyService.updateCompany(companyService.getOneCompany(id));
    }

    @PutMapping("/companies/{id}/address")
    public SuccessResponse updateAddress(@RequestBody Address address, @PathVariable Long id) {
        return addressService.updateAddress(address,companyService.getOneCompany(id).getAddress().getId());
    }

    @DeleteMapping("/companies/{id}/address")
    public SuccessResponse deleteAddress(@PathVariable Long id) {
       return addressService.deleteAddress(companyService.getOneCompany(id).getAddress().getId());
    }
}
