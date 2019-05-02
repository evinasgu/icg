package com.icg.personapi.business;

import com.icg.personapi.model.data.Client;

import java.util.Date;
import java.util.List;

/**
 * StatisticUtil provides the necessary tools to calculate mean and standard deviation over clients
 */
public class StatisticUtil {
    private final static Integer AVERAGE_AGE_OF_DEATH = 75; //Average of the death in Peru

    /**
     * Calculate the mean over a list of clients
     * @param clients List of clients
     * @return
     */
    public static Double calculateMean(List<Client> clients) {
        Integer n = clients.size();

        if(n == 0) {
            return 0d;
        }
        return clients.stream()
                .mapToDouble(c -> c.getAge())
                .sum() / n;
    }

    /**
     * Calculate the standard deviation over a list of clients
     * @param clients List of clients
     * @return
     */
    public static Double calculateStandardDeviation(List<Client> clients) {
        Double mean = calculateMean(clients);
        Integer n = clients.size();

        if(n == 0 || n == 1) {
            return 0d;
        }
        return Math.sqrt(clients.stream()
                .mapToDouble(cl -> cl.getAge())
                .map(age -> Math.pow(age - mean, 2))
                .sum() / (n - 1));
    }

    /**
     * Calculate the expected Date of death of person given the
     * @param birthDate Represents the birth date of a client
     * @return
     */
    public static Date calculateAgeofDeath(Date birthDate) {
        return new Date(birthDate.getYear() + AVERAGE_AGE_OF_DEATH, birthDate.getMonth(), birthDate.getDate());
    }
}
