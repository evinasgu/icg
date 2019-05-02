package com.icg.personapi.model.response;

import com.icg.personapi.model.data.Client;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ClientResponse {
    Client client;
    Date approximatedDefuntionDate;
}
