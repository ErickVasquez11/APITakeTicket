package com.taketicket.documentos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taketicket.documentos.models.dtos.tickets.AllTicketDTO;
import com.taketicket.documentos.models.entities.Ticket;
import com.taketicket.documentos.services.TicketService;
import com.taketicket.documentos.utils.RequestErrorHandler;

@RestController
@RequestMapping("/ticket/")
@CrossOrigin("*")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	//obtener los tickets
	
}
