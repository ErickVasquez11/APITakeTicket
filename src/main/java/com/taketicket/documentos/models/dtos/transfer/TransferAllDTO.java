package com.taketicket.documentos.models.dtos.transfer;

import java.sql.Timestamp;
import java.util.UUID;

import com.taketicket.documentos.models.entities.Ticket;
import com.taketicket.documentos.models.entities.User;

public class TransferAllDTO {

	private UUID id;
	private java.sql.Timestamp data_received;
	private java.sql.Timestamp data_emit;
	private String hash;
	private Boolean state;
	private Ticket ticket;
	private User userEmit;
	private User userReceived;
	
	
	public TransferAllDTO(UUID id, Timestamp data_received, Timestamp data_emit, String hash, Boolean state,
			Ticket ticket, User userEmit, User userReceived) {
		super();
		this.id = id;
		this.data_received = data_received;
		this.data_emit = data_emit;
		this.hash = hash;
		this.state = state;
		this.ticket = ticket;
		this.userEmit = userEmit;
		this.userReceived = userReceived;
	}
	
	
}
