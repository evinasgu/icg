package com.icg.personapi.repository;

import com.icg.personapi.model.response.KPIClientResponse;

public interface KpiRepository {
    KPIClientResponse updateKpiRepository(KPIClientResponse input);
}
