package com.icg.personapi;

import com.icg.personapi.model.data.Client;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DataGenerator {
    public static List<Client> generateClientData() {
        List<Long> idList = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        List<String> nameList = Arrays.asList(
                "pepito1",
                "pepito2",
                "pepito3",
                "pepito4",
                "pepito5"
        );
        List<String> lastNameList = Arrays.asList(
                "popeye1",
                "popeye2",
                "popeye3",
                "popeye4",
                "popeye5"
        );

        List<Integer> ageList = Arrays.asList(35, 21, 27, 33, 39);

        List<Date> birthDateList = Arrays.asList(
                new DateTime(1983, 5, 20, 0, 0).toDate(),
                new DateTime(1984, 6, 21, 0, 0).toDate(),
                new DateTime(1985, 7, 22, 0, 0).toDate(),
                new DateTime(1986, 8, 23, 0, 0).toDate(),
                new DateTime(1987, 9, 24, 0, 0).toDate()
        );

        List<Client> clientList = new ArrayList<>();
        for (int i = 0; i < idList.size(); i++) {
            clientList.add(Client.builder()
            .age(ageList.get(i))
            .name(nameList.get(i))
            .lastName(lastNameList.get(i))
            .birthDate(birthDateList.get(i))
            .id(idList.get(i))
            .build());
        }

        return clientList;
    }
}