package office.furniture.test.api;

import office.furniture.test.domain.Client;
import office.furniture.test.jpa.ClientRepository;
import office.furniture.test.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by artyom on 15.25.11.
 */

@RestController
@RequestMapping(value = "/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Client getClientById(@PathVariable("id") Long id) {
        return clientService.getClientById(id);
    }

    @RequestMapping(value = "put", method = RequestMethod.PUT)
    public Long saveClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }



}
