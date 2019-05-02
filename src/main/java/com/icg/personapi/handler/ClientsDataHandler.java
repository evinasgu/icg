package com.icg.personapi.handler;

import com.icg.personapi.exception.BusinessException;
import com.icg.personapi.model.data.Client;
import com.icg.personapi.model.response.ClientResponse;
import com.icg.personapi.service.ClientDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class handle the request -> response life cycle for the clients basic information
 */
@RestController
@RequestMapping("/api/v1/data")
public class ClientsDataHandler {
    @Autowired
    ClientDataService dataService;

    /**
     * This method has the responsibility of handle requests for find all clients feature
     * @return
     */
    @GetMapping("/listclientes")
    public List<ClientResponse> findAllClients() {
        return dataService.fetchClients();
    }

    /**
     * This method has the responsibility of handle requests for create client feature
     * @param client
     * @return
     * @throws BusinessException
     */
    @PostMapping("/creacliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client) throws BusinessException {
        return dataService.saveClient(client);
    }
}
