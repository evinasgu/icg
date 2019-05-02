package com.icg.personapi.service.impl;

import com.icg.personapi.business.ClientBusinessValidation;
import com.icg.personapi.business.ClientResponseTransformer;
import com.icg.personapi.exception.BusinessException;
import com.icg.personapi.model.data.Client;
import com.icg.personapi.model.response.ClientResponse;
import com.icg.personapi.repository.ClientRepository;
import com.icg.personapi.service.ClientDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientDataServiceImpl implements ClientDataService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<ClientResponse> fetchClients() {
        List<Client> clientList = clientRepository.findAll();
        List<ClientResponse> clientResponseList = clientList.stream()
                .map(ClientResponseTransformer::transformClientToClientResponse)
                .collect(Collectors.toList());
        return clientResponseList;
    }

    @Override
    public Client saveClient(Client client) throws BusinessException {
        if(validateClient(client)) {
            return clientRepository.save(client);
        }
        throw new BusinessException("Error in business validation over this object");
    }

    private Boolean validateClient(Client client) {
        return ClientBusinessValidation.validateClientAge(client) &&
                ClientBusinessValidation.validateClientBirthDate(client);
    }
}
