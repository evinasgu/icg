package com.icg.personapi.repository;

import com.icg.personapi.model.data.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Client save(Client client);
    List<Client> findAll();
}
