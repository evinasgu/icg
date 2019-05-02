package com.icg.personapi.business;

import com.icg.personapi.DataGenerator;
import com.icg.personapi.model.data.Client;
import com.icg.personapi.model.response.ClientResponse;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ClientResponseTransformerTest {
    List<Client> clientList;

    @Before
    public void setUp() throws Exception {
        clientList = DataGenerator.generateClientData();
    }

    @Test
    public void transformClientToClientResponse() {
        ClientResponse expectedClientResponse = ClientResponse.builder()
                .client(clientList.get(0))
                .approximatedDefuntionDate(new DateTime(clientList.get(0).getBirthDate()).plusYears(75).toDate())
                .build();
        ClientResponse actualClientResponse = ClientResponseTransformer.transformClientToClientResponse(clientList.get(0));
        assertEquals(expectedClientResponse, actualClientResponse);
    }

    @Test
    public void transformClientToClientResponseNonValidCase() {
        ClientResponse expectedClientResponse = ClientResponse.builder()
                .client(clientList.get(0))
                .approximatedDefuntionDate(new DateTime(clientList.get(0).getBirthDate()).plusYears(73).toDate())
                .build();
        ClientResponse actualClientResponse = ClientResponseTransformer.transformClientToClientResponse(clientList.get(0));
        assertNotEquals(expectedClientResponse, actualClientResponse);
    }
}