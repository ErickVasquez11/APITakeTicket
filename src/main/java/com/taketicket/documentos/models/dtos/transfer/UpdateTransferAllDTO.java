package com.taketicket.documentos.models.dtos.transfer;

import com.taketicket.documentos.models.entities.Ticket;
import com.taketicket.documentos.models.entities.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateTransferAllDTO {

	@NotBlank(message = "Warn! hash is required")
	private String hash;
	
	@NotBlank(message = "Warn! state is required")
	private Boolean state;
	
	@NotNull(message = "Error! date emit is required")
	private java.sql.Timestamp date_emit;
	
	@NotNull(message = "Error! date recived is required")
	private java.sql.Timestamp date_recived;

	@NotNull(message = "Error! ticket is required ")
	private Ticket ticket;
	
	@NotNull(message = "Error! userEmit is required ")
	private User userEmit;
	
	@NotNull(message = "Error! userReceived is required ")
	private User userReceived;
}
	
	
	
	
