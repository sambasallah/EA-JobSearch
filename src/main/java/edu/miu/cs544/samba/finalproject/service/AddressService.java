package edu.miu.cs544.samba.finalproject.service;

import edu.miu.cs544.samba.finalproject.entity.Address;
import edu.miu.cs544.samba.finalproject.entity.Client;
import edu.miu.cs544.samba.finalproject.entity.Company;
import edu.miu.cs544.samba.finalproject.repository.AddressRepository;
import edu.miu.cs544.samba.finalproject.repository.ClientRepository;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.util.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;


    public SuccessResponse createAddress(Address address) {
        addressRepository.save(address);
        return UtilFunctions.handleSuccessResponse(true, "Address Created!");
    }


    public Address getOneAddress(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> {
            return UtilFunctions.handleResourceNotFoundException("Address with id " + id + " not found!");
        });

    }

    public SuccessResponse updateAddress(Address address, Long id) {
        Address addressToUpdate = getOneAddress(id);
        addressToUpdate.setCity(address.getCity());
        addressToUpdate.setState(address.getState());
        addressToUpdate.setZip(address.getZip());
        addressToUpdate.setStreet(address.getCity());

        addressRepository.save(addressToUpdate);

        return UtilFunctions.handleSuccessResponse(true, "Address Updated!");

    }

    public SuccessResponse deleteAddress(Long id) {
        Address address = getOneAddress(id);
        addressRepository.delete(address);
        return UtilFunctions.handleSuccessResponse(true, "Address with id " + id + " deleted!");
    }
}


