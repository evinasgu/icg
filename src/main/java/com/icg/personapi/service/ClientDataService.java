package com.icg.personapi.service;

import com.icg.personapi.exception.BusinessException;
import com.icg.personapi.model.data.Client;
import com.icg.personapi.model.response.ClientResponse;

import java.util.List;

public interface ClientDataService {
    List<ClientResponse> fetchClients();
    Client saveClient(Client client) throws BusinessException;
}
