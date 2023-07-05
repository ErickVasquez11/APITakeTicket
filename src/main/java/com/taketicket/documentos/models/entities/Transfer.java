package com.taketicket.documentos.models.entities;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "transfer")
public class Transfer {

	@Id
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID code;
	
	@Column(name = "data_received")
	private Timestamp data_received;
	
	@Column(name = "data_emit")
	private Timestamp data_emit;
	
	@Column(name = "code")
	private String hash;
	
	@Column(name = "state", insertable = false)
	private Boolean state;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ticket",nullable = true)
	private Ticket ticket;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user_emit",nullable = true)
	private User userEmit;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user_received",nullable = true)
	private User userReceived;

	public Transfer(Timestamp data_received, Timestamp data_emit, String hash, Boolean state, Ticket ticket,
			User userEmit, User userReceived) {
		super();
		this.data_received = data_received;
		this.data_emit = data_emit;
		this.hash = hash;
		this.state = state;
		this.ticket = ticket;
		this.userEmit = userEmit;
		this.userReceived = userReceived;
	}
	
}
