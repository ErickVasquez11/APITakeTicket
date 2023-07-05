package com.taketicket.documentos.models.entities;

import java.security.Timestamp;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(exclude = {"locations","tickets"})
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event {
	

	@Id
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID code;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "involved")
	private String involved;
	
	@Column(name = "date")
	private Timestamp date;
	
	/*
	@Column(name = "image")
	private String image;
	*/
	@Column(name = "duration")
	private java.sql.Timestamp duration;
	
	@Column(name = "sponsor")
	private String sponsor;
	
	@Column(name = "active", insertable = false)
	private Boolean active;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_category", nullable = true)
	private Category category;
	
	 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_place", nullable = true)
	private Place place;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user", nullable = true)
	private User user;
	
	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Location>locations;
	
	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Ticket>tickets;

	
	@SuppressWarnings("unchecked")
	public Event(UUID code, String title, String involved, java.sql.Timestamp duration, String sponsor, Boolean active,
			Category category, Place place, User user, Location locations, Ticket ticket) {
		super();
		this.code = code;
		this.title = title;
		this.involved = involved;
		this.duration = duration;
		this.sponsor = sponsor;
		this.active = active;
		this.category = category;
		this.place = place;
		this.user = user;
		this.locations = (List<Location>) locations;
		this.tickets = (List<Ticket>) ticket;
	}


	public Event(String title2, String involved2, java.sql.Timestamp date2, java.sql.Timestamp duration2,
			String sponsor2, Boolean active2, Category category2, Place place2, User user2, Location locations2,
			Ticket tickets2) {
		// TODO Auto-generated constructor stub
	}

	

	
	
	
}
