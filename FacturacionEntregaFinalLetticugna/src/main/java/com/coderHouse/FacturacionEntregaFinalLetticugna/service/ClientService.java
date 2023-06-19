package com.coderHouse.FacturacionEntregaFinalLetticugna.service;

import com.coderHouse.FacturacionEntregaFinalLetticugna.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coderHouse.FacturacionEntregaFinalLetticugna.repository.ClientRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client getClientById(int id) throws Exception {
        Optional<Client> client = clientRepository.findById(id);//obtengo el cliente por id
        if(client.isEmpty()){// si el cliente es null devuelvo null
            return null;
        } else {
            return client.get();
        }
    }

    public Client postClient(Client client) throws Exception {
        return clientRepository.save(client);
    }

    public String deleteClientById(int id) throws Exception {
        Optional<Client> client = clientRepository.findById(id);//obtengo el cliente por id
        if(client.isEmpty()){// si el cliente es null devuelvo null
            return null;
        } else {
            clientRepository.delete(client.get());
            return "El cliente " + client.get().getId() + " a sido eliminado de la lista";
        }
    }

    public String updateClientById(Client client, int id) throws Exception {
        Optional<Client> clientExist = clientRepository.findById(id);//obtengo el cliente por id
        if(clientExist.isEmpty()){// si el cliente es null devuelvo null
            throw new Exception("Client not exist");
        } else {
            return "El cliente con el id " + clientExist.get().getId() + " a sido modificado de la siguiente manera: Nombre "  +  clientExist.get().getName() + " | Apellido "+  clientExist.get().getLastname() + " | Documento "+  clientExist.get().getDocnumber();
        }
    }



}
