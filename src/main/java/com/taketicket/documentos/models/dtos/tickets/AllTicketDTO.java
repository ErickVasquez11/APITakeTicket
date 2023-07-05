package com.taketicket.documentos.models.dtos.tickets;

import java.util.UUID;

import lombok.Data;

@Data
public class AllTicketDTO {

	UUID code;
	private String event;
	private String user;
	private java.sql.Timestamp date;
	
	public AllTicketDTO(UUID code, String event, String user, java.sql.Timestamp date) {
		super();
		this.code = code;
		this.event = event;
		this.user = user;
		this.date = date;
	}
}
