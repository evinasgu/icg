package com.icg.personapi.business;

import com.icg.personapi.model.data.Client;
import com.icg.personapi.model.response.ClientResponse;

/**
 * This class makes the necessary transformations over client domain objects to ClientResponse objects or other to be
 * added in the future
 */
public class ClientResponseTransformer {
    /**
     * This method makes the transformations from a client object to a ClientResponse object
     * @param client his parameter represents a client to be transformed
     * @return
     */
    public static ClientResponse transformClientToClientResponse(Client client) {
        ClientResponse clientResponse = ClientResponse.builder()
                .client(client)
                .approximatedDefuntionDate(StatisticUtil.calculateAgeofDeath(client.getBirthDate()))
                .build();
        return clientResponse;
    }
}
