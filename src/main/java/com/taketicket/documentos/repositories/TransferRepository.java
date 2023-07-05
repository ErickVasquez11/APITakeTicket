package com.taketicket.documentos.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.taketicket.documentos.models.entities.Ticket;

public interface TransferRepository extends ListCrudRepository<Ticket, UUID>{


}
