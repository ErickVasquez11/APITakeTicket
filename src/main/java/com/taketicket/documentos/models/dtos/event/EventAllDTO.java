package com.taketicket.documentos.models.dtos.event;

import java.sql.Timestamp;
import java.util.UUID;

import com.taketicket.documentos.models.entities.Category;
import com.taketicket.documentos.models.entities.Location;
import com.taketicket.documentos.models.entities.Place;
import com.taketicket.documentos.models.entities.Ticket;
import com.taketicket.documentos.models.entities.User;

import lombok.Data;

@Data
public class EventAllDTO {

	private UUID id;
	private String title;
	private String involved;
	private java.sql.Timestamp date;
	private java.sql.Timestamp duration;
	private String sponsor;
	private Boolean active;
	private Category category;
	private Place place;
	private User user;
	private Location locations;
	private Ticket tickets;
	
	
	public EventAllDTO(UUID id, String title, String involved, Timestamp date, Timestamp duration, String sponsor,
			Boolean active, Category category, Place place, User user, Location locations, Ticket tickets) {
		super();
		this.id = id;
		this.title = title;
		this.involved = involved;
		this.date = date;
		this.duration = duration;
		this.sponsor = sponsor;
		this.active = active;
		this.category = category;
		this.place = place;
		this.user = user;
		this.locations = locations;
		this.tickets = tickets;
	}
	
	
}
