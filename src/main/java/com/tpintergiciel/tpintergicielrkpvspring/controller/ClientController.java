package com.tpintergiciel.tpintergicielrkpvspring.controller;

import com.tpintergiciel.tpintergicielrkpvspring.config.WebConfig;
import com.tpintergiciel.tpintergicielrkpvspring.classes.Client;
import com.tpintergiciel.tpintergicielrkpvspring.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    // Create a new user
    @PostMapping("/create")
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    // Get all users
    @GetMapping("/get")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        System.out.println(clientService.loginClient(username));
        return clientService.loginClient(username);
    }
    @PostMapping("/connected")
    public List<Client> getConnectedClient() {
        return clientService.getAllConnectedClients();
    }

    // Get user by ID

}