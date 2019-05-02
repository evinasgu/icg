package com.icg.personapi.service;

import com.icg.personapi.model.response.KPIClientResponse;

public interface ClientStatsService {
    KPIClientResponse fetchKPIData();
}
