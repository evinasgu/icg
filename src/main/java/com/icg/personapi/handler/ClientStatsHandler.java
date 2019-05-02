package com.icg.personapi.handler;

import com.icg.personapi.model.response.KPIClientResponse;
import com.icg.personapi.service.ClientStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
public class ClientStatsHandler {

    @Autowired
    ClientStatsService clientStatsService;

    /**
     * This method has the responsibility of handle the requests for fetch KPI feature
     * @return
     */
    @GetMapping("/kpideclientes")
    public KPIClientResponse getKPIFromClients() {
        return clientStatsService.fetchKPIData();
    }
}
