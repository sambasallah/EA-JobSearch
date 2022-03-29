package edu.miu.cs544.samba.finalproject.service;

import edu.miu.cs544.samba.finalproject.entity.Client;
import edu.miu.cs544.samba.finalproject.entity.Company;
import edu.miu.cs544.samba.finalproject.repository.ClientRepository;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.util.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Company> getAllClients() {
        return clientRepository.findAll();
    }

    public SuccessResponse createClient(Client client) {
        clientRepository.save(client);
        return UtilFunctions.handleSuccessResponse(true, "Client Created!");
    }


    public Company getOneClient(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> {
            return UtilFunctions.handleResourceNotFoundException("Client with id " + id + " not found!");
        });

    }

    public SuccessResponse updateClient(Client client, Long id) {
        Company clientToUpdate = getOneClient(id);
        clientToUpdate.setAddress(client.getAddress());
        clientToUpdate.setJobs(client.getJobs());
        clientToUpdate.setName(client.getName());

        clientRepository.save(clientToUpdate);

        return UtilFunctions.handleSuccessResponse(true, "Client Updated!");

    }

    public SuccessResponse deleteClient(Long id) {
        Company client = getOneClient(id);
        clientRepository.delete(client);
        return UtilFunctions.handleSuccessResponse(true, "Client with id " + id + " deleted!");
    }
}


