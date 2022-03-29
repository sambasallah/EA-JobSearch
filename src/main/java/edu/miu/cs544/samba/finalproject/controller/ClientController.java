package edu.miu.cs544.samba.finalproject.controller;

import edu.miu.cs544.samba.finalproject.entity.Client;
import edu.miu.cs544.samba.finalproject.entity.Company;
import edu.miu.cs544.samba.finalproject.response.SuccessResponse;
import edu.miu.cs544.samba.finalproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Company> all() {
        return clientService.getAllClients();
    }

    @GetMapping("/clients/{id}")
    public Company one(@PathVariable Long id) {
        return clientService.getOneClient(id);
    }

    @PostMapping("/clients")
    public SuccessResponse newClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/clients/{id}")
    public SuccessResponse updateCompany(@RequestBody Client client, @PathVariable Long id) {
        return clientService.updateClient(client,id);
    }

    @DeleteMapping("/clients/{id}")
    public SuccessResponse deleteJob(@PathVariable Long id) {
        return clientService.deleteClient(id);
    }
}
