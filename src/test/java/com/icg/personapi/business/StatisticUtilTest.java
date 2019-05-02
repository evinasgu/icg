package com.icg.personapi.business;

import com.icg.personapi.DataGenerator;
import com.icg.personapi.model.data.Client;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StatisticUtilTest {

    List<Client> clientList;

    @Before
    public void setUp() throws Exception {
        clientList = DataGenerator.generateClientData();
    }

    @Test
    public void calculateMean() {
        Double expectedMean = 31d;
        Double actualMean = StatisticUtil.calculateMean(clientList);
        assertEquals(expectedMean, actualMean);
    }

    @Test
    public void calculateMeanZeroCase() {
        Double expectedMean = 0d;
        Double actualMean = StatisticUtil.calculateMean(new ArrayList<>());
        assertEquals(expectedMean, actualMean);
    }

    @Test
    public void calculateStandardDeviation() {
        Double expectedStandardDeviation = 7.0710678118654755;
        Double actualStandardDeviation = StatisticUtil.calculateStandardDeviation(clientList);
        assertEquals(expectedStandardDeviation, actualStandardDeviation);
    }

    @Test
    public void calculateStandardDeviationZeroCase() {
        Double expectedStandardDeviation = 0d;
        Double actualStandardDeviation = StatisticUtil.calculateStandardDeviation(new ArrayList<>());
        assertEquals(expectedStandardDeviation, actualStandardDeviation);
    }

    @Test
    public void calculateAgeofDeath() {
        Client client = clientList.get(0);
        DateTime expectedAgeOfDeath = new DateTime(client.getBirthDate()).plusYears(75);
        DateTime actualAgeOfDeath = new DateTime(StatisticUtil.calculateAgeofDeath(client.getBirthDate()));
        assertEquals(expectedAgeOfDeath, actualAgeOfDeath);
    }
}