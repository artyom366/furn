package office.furniture.test.service;

import office.furniture.test.domain.Client;
import office.furniture.test.jpa.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.tools.jar.CommandLine;

/**
 * Created by artyom on 15.27.11.
 */

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findOne(id);
    }

    public Long saveClient(Client client) {
        return clientRepository.save(client).getId();
    }
}
