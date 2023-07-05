package com.taketicket.documentos.models.dtos.tickets;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateTicketDTO {

	@NotBlank(message = "Warn! Ticket code is required")
	private String code;
	
	@NotBlank(message = "Warn! Event is required")
	private String event;
	
	@NotBlank(message = "Warn! User is required")
	private String user;
}
