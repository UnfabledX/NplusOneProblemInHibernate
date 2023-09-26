package com.chiit.nplusone;

import com.chiit.nplusone.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService clientService;
    private final ClientRepository clientRepository;
    @Autowired
    public ClientController(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/fillDB")
    public String fillDataBase() {
        clientService.generateDB();
        return "Amount clients: " + clientRepository.count();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Client> findByNameContaining(@RequestParam String clientName) {
        List<Client> clients = clientService.findByNameContaining(clientName);
        return clients;
    }
}
