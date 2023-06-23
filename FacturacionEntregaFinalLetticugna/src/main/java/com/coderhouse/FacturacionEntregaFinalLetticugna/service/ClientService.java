package com.coderhouse.FacturacionEntregaFinalLetticugna.service;


import com.coderhouse.FacturacionEntregaFinalLetticugna.model.Client;
import com.coderhouse.FacturacionEntregaFinalLetticugna.repository.ClientRepository;
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

    public Client getClientById(int id) throws Exception {
        Optional<Client> cliente = clientRepository.findById(id);
        if(cliente.isEmpty()){
            throw new Exception("Client with id: " + id + ", not found");
        } else {
            return cliente.get();
        }
    }

    public String updateClientById(Client client, int id) throws Exception {
        Optional<Client> clientExist = clientRepository.findById(id);//obtengo el cliente por id
        if(clientExist.isEmpty()){// si el cliente es null devuelvo null
            throw new Exception("Client not exist");
        } else {
            clientRepository.save(client);
            return "El cliente con el id " + clientExist.get().getId() + " a sido modificado de la siguiente manera: Nombre "  +  clientExist.get().getName() + " | Apellido "+  clientExist.get().getLastname() + " | Documento "+  clientExist.get().getDocnumber();

        }
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

    public boolean clientExist (int id) throws Exception {
        Optional<Client> cliente = clientRepository.findById(id);
        return cliente.isPresent();
    }


}
