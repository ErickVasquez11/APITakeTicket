package com.taketicket.documentos.models.entities;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "validation")
public class Validation {

	@Id
	@Column(name = "id")
	private UUID code;
	
	@Column(name = "state", insertable = false)
	private Boolean state;
	
	@Column(name = "date_emit")
	private java.sql.Timestamp date_emit;
	
	@Column(name = "date_received")
	private java.sql.Timestamp  date_received;
	
	//Codigo del ticket tipo hash
	@Column(name = "code")
	private String hash;
	
	/*
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ticket",nullable = true)
	private Ticket ticket;
	*/
	
	public Validation(Boolean state, java.sql.Timestamp date_emit, Timestamp date_received, String hash) {
		super();
		this.state = state;
		this.date_emit = date_emit;
		this.date_received = date_received;
		this.hash = hash;
		//this.ticket = ticket;
	}

	
}
