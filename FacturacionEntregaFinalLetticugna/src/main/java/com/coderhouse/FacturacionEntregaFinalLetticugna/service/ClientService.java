package com.coderhouse.FacturacionEntregaFinalLetticugna.service;

import com.coderhouse.FacturacionEntregaFinalLetticugna.model.*;
import com.coderhouse.FacturacionEntregaFinalLetticugna.repository.ClientRepository;
import com.coderhouse.FacturacionEntregaFinalLetticugna.repository.InvoiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    private InvoiceDetailRepository invoiceDetailRepository;

    public Client postClient(Client client) throws Exception {
        List<Client> clientList = clientRepository.findAll();
        if (clientList.size() > 0) {
            for (Client clientExistente : clientList) {
                if (clientExistente.getDocnumber() == client.getDocnumber()) {
                    throw new Exception("The docnumber already exists");
                }
            }
        }
        if (!client.naneValidate(client.getName())) {
            throw new Exception("Name Null");
        } else if (!client.lastNameValidate(client.getLastname())) {
            throw new Exception("LastName Null");
        } else if (client.docNumberValidate(client.getDocnumber())) {
            throw new Exception("DocNumber Null");
        } else {
            clientRepository.save(client);
            return null;
        }
    }

    public Client getClientById(int id) throws Exception {
        Optional<Client> cliente = clientRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new Exception("Client with id: " + id + ", not found");
        } else {
            return cliente.get();
        }
    }

    public String updateClientById(Client client, int id) throws Exception {
        Optional<Client> clientExist = clientRepository.findById(id);//obtengo el cliente por id

        List<Client> clientList = clientRepository.findAll();
        if (clientList.size() > 0) {
            for (Client clientExistente : clientList) {
                if (clientExistente.getDocnumber() == client.getDocnumber()) {
                    throw new Exception("The docnumber already exists");
                }
            }
        }


        if (clientExist.isEmpty()) {// si el cliente es null devuelvo null
            throw new Exception("Client not exist");
        } else {
            if (!client.naneValidate(client.getName())) {
                throw new Exception("Name Null");
            } else if (!client.lastNameValidate(client.getLastname())) {
                throw new Exception("LastName Null");
            } else if (client.docNumberValidate(client.getDocnumber())) {
                throw new Exception("DocNumber Null");
            } else {
                clientRepository.save(client);
                return null;
            }
        }
    }

    public String deleteClientById(int id) throws Exception {
        try {
            Optional<Client> client = clientRepository.findById(id);//obtengo el cliente por id
            if (client.isEmpty()) {// si el cliente es null devuelvo null
                throw new Exception("Client not exist");
            } else {
                clientRepository.delete(client.get());
                return null;
            }
        } catch (Exception e) {
            throw new Exception("The Client cannot be deleted as it has invoices loaded");
        }
    }


}
