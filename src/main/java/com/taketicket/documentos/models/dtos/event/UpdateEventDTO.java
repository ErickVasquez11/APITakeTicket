package com.taketicket.documentos.models.dtos.event;

import java.util.UUID;

import com.taketicket.documentos.models.entities.Category;
import com.taketicket.documentos.models.entities.Location;
import com.taketicket.documentos.models.entities.Place;
import com.taketicket.documentos.models.entities.Ticket;
import com.taketicket.documentos.models.entities.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateEventDTO {

	@NotBlank(message = "Warn! title is required")
	private UUID code;
	
	@NotBlank(message = "Warn! title is required")
	private String title;
	
	@NotBlank(message = "Warn! involved is required")
	private String involved;
	
	@NotBlank(message = "Warn! sponsor is required")
	private String sponsor;
	
	@NotNull(message = "Warn! active is required")
	private Boolean active;
	
	@NotBlank(message = "Warn! category is required")
	private Category category;
	
	@NotBlank(message = "Warn! place is required")
	private Place place;
	
	@NotBlank(message = "Warn! user is required")
	private User user;
	
	@NotBlank(message = "Warn! location is required")
	private Location locations;
	
	@NotBlank(message = "Warn! ticket is required")
	private Ticket tickets;
	
	
	
}
