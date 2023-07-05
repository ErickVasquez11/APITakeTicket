package com.taketicket.documentos.services;

import java.sql.Timestamp;
import java.util.List;

import com.taketicket.documentos.models.dtos.tickets.SaveTicketDTO;
import com.taketicket.documentos.models.dtos.tickets.UpdateTicketDTO;
import com.taketicket.documentos.models.entities.Event;
import com.taketicket.documentos.models.entities.Ticket;
import com.taketicket.documentos.models.entities.User;

public interface TicketService {

	void save(SaveTicketDTO ticketInfo, User user) throws Exception;
	void update(UpdateTicketDTO ticketInfo) throws Exception;
	void deleteOneById(String code) throws Exception;
	Ticket findOneById(String code);
	List<Ticket> findAll();
	
	List<Ticket> findEvent(String event);
	void save(Ticket ticket, Event event, User user, Timestamp timestamp) throws Exception;
}
