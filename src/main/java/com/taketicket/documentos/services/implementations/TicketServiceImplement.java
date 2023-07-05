package com.taketicket.documentos.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taketicket.documentos.models.dtos.tickets.SaveTicketDTO;
import com.taketicket.documentos.models.dtos.tickets.UpdateTicketDTO;
import com.taketicket.documentos.models.entities.Event;
import com.taketicket.documentos.models.entities.Ticket;
import com.taketicket.documentos.models.entities.User;
import com.taketicket.documentos.repositories.TicketRepository;
import com.taketicket.documentos.services.TicketService;

@Service
public class TicketServiceImplement implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public void save(Ticket ticket, Event event, User user, java.sql.Timestamp timestamp) throws Exception {
		Ticket relation = new Ticket(ticket, event, user, timestamp);
		ticketRepository.save(relation);
	}

	@Override
	public void save(SaveTicketDTO ticketInfo, User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UpdateTicketDTO ticketInfo) throws Exception {
		UUID _code = UUID.fromString(ticketInfo.getCode());
		Ticket ticket = ticketRepository.findById(_code).orElse(null);
		
		if (ticket == null ) return;
		
		/*
		ticket.setCode(ticketInfo.getCode());
		ticket.setEvent(ticketInfo.getEvent());
		ticket.setUser(ticketInfo.getUser());
		
		*/
		ticketRepository.save(ticket);
		
		
		
	}

	@Override
	public void deleteOneById(String code) throws Exception {
		UUID _code = UUID.fromString(code);
		ticketRepository.deleteById(_code);
		
	}

	@Override
	public Ticket findOneById(String code) {
		try {
			UUID _code = UUID.fromString(code);
			return ticketRepository.findById(_code).orElse(null);
		} catch ( Exception e) {
			return null;
		}
	}

	@Override
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	public List<Ticket> findEvent(String event) {
		return ticketRepository.findByUserContaining(event);
	}
	
	
}
