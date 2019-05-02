package com.icg.personapi.service.impl;

import com.icg.personapi.business.StatisticUtil;
import com.icg.personapi.model.data.Client;
import com.icg.personapi.model.response.KPIClientResponse;
import com.icg.personapi.repository.ClientRepository;
import com.icg.personapi.service.ClientStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientStatsServiceImpl implements ClientStatsService {
    @Autowired
    ClientRepository repository;

    @Override
    public KPIClientResponse fetchKPIData() {
        List<Client> clientList = repository.findAll();
        KPIClientResponse kpiClientResponse = KPIClientResponse.builder()
                .clientsAgeMean(StatisticUtil.calculateMean(clientList))
                .clientsAgeStandardDeviation(StatisticUtil.calculateStandardDeviation(clientList))
                .build();
        return kpiClientResponse;
    }
}
