package com.icg.personapi.business;

import com.icg.personapi.model.data.Client;
import org.joda.time.DateTime;
import org.joda.time.Years;

import java.util.Date;

/**
 * This class has the responsibility of validate client objects
 */
public class ClientBusinessValidation {
    /**
     * This method validates the birthDate field of a client object
     * @param client This parameter represents a client to be validated
     * @return
     */
    public static Boolean validateClientBirthDate(Client client) {
        DateTime clientDateTime = new DateTime(client.getBirthDate());
        return clientDateTime.isBefore(DateTime.now());
    }

    /**
     * this method validates the age of a client object
     * @param client This parameter represents a client to be validated
     * @return
     */
    public static Boolean validateClientAge(Client client) {
        DateTime birthdateClientDateTime = new DateTime(client.getBirthDate());
        DateTime actualClientDateTime = new DateTime(new Date());
        Years expectedAge = Years.yearsBetween(birthdateClientDateTime, actualClientDateTime);
        return expectedAge.getYears() - client.getAge() == 0;
    }
}
