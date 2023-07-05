package com.taketicket.documentos.models.dtos.tickets;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveTicketDTO {

	@NotBlank(message = "Error! Event is required")
	private String event;
	
	@NotBlank(message = "Error! User is required")
	private String user;
}
