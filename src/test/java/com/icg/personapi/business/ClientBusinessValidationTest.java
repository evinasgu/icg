package com.icg.personapi.business;

import com.icg.personapi.DataGenerator;
import com.icg.personapi.model.data.Client;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClientBusinessValidationTest {
    List<Client> clientList;

    @Before
    public void setUp() throws Exception {
        clientList = DataGenerator.generateClientData();
    }

    @Test
    public void validateClientBirthDate() {
        Client client = clientList.get(0);
        assertTrue(ClientBusinessValidation.validateClientBirthDate(client));
    }

    @Test
    public void validateClientBirthDateNonValidCase() {
        Client client = clientList.get(0);
        client.setBirthDate(new DateTime().plusYears(4).toDate());
        assertFalse(ClientBusinessValidation.validateClientBirthDate(client));
    }

    @Test
    public void validateClientAge() {
        Client client = clientList.get(0);
        assertTrue(ClientBusinessValidation.validateClientAge(client));
    }

    @Test
    public void validateClientAgeNonValidCase() {
        Client client = clientList.get(0);
        client.setAge(22);
        assertFalse(ClientBusinessValidation.validateClientAge(client));
    }
}