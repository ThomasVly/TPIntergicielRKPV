package com.tpintergiciel.tpintergicielrkpvspring.services;

import com.tpintergiciel.tpintergicielrkpvspring.classes.Client;
import com.tpintergiciel.tpintergicielrkpvspring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tpintergiciel.tpintergicielrkpvspring.config.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public boolean loginClient(String username) {
        System.out.println("ALLOOO");

        for (Client client : getAllClients()) {
            System.out.println(client.getNom());
            System.out.println(username);

            if (Objects.equals(username, client.getNom())) {
                client.setLogged(true);
                clientRepository.save(client);  // 🔥 Enregistrement en base
                return true;
            }
        }
        return false;
    }

    public void logoutClient(String username) {
        for (Client client : getAllClients()) {
            System.out.println("Déconnexion demandée pour : " + username + "test sur " + client.getNom());
            if (Objects.equals(username, client.getNom())) {
                client.setLogged(false);
                clientRepository.save(client);  // 🔥 Enregistrement en base
            }
        }
    }

    public List<Client> getAllConnectedClients(){
        List<Client> clients = getAllClients();
        List<Client> connectedClients = new ArrayList<>();
        for (Client client : clients) {
            if(client.isLogged()){
                connectedClients.add(client);

            }
        }
        return connectedClients;
    }

}