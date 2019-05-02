package com.icg.personapi.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KPIClientResponse {
    Double clientsAgeMean;
    Double clientsAgeStandardDeviation;
}
