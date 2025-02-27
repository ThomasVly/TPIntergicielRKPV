package com.tpintergiciel.tpintergicielrkpvspring.services;

import com.tpintergiciel.tpintergicielrkpvspring.classes.Client;
import com.tpintergiciel.tpintergicielrkpvspring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    // Create a new user
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    // Get all users
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }


}