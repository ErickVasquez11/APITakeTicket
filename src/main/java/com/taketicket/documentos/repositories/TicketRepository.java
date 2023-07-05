package com.taketicket.documentos.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.taketicket.documentos.models.entities.Ticket;

public interface TicketRepository extends ListCrudRepository<Ticket, UUID>{
	
	List<Ticket> findByUserContaining( String user);

}
