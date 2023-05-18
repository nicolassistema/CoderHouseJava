package com.coderhouse.FacturacionPrimeraEntregaLetticugna.service;


import com.coderhouse.FacturacionPrimeraEntregaLetticugna.model.Client;
import com.coderhouse.FacturacionPrimeraEntregaLetticugna.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client postClient(Client client) throws Exception {
        return clientRepository.save(client);
    }

    public Client getClient(int id) throws Exception {
        Optional<Client> clienteObtenido = this.clientRepository.findById(id);
        return clienteObtenido.get();
    }
}