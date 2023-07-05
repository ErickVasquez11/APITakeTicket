package com.taketicket.documentos.models.entities;

import java.sql.Timestamp;
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


@Data
//@ToString(exclude = {"validations","transfers"})
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID code;
	
	@Column(name = "date")
	private Timestamp date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_event",nullable = true)
	private Event event;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_location",nullable = true)
	private Location location;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user",nullable = true)
	private User user;
	
	/*
	@OneToMany(mappedBy = "ticket",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Validation>validations;
	
	@OneToMany(mappedBy = "ticket",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Transfer>transfers;

	*/
	public Ticket(java.sql.Timestamp date, Event event,  User user) {
		super();
		this.date = date;
		this.event = event;
		this.location = location;
		this.user = user;
	}

	public Ticket(Ticket ticket, Event event2, User user2, Timestamp timestamp) {
		// TODO Auto-generated constructor stub
	}



}
