package com.taketicket.documentos.models.entities;

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
//@ToString(exclude = {"tickets"})
@NoArgsConstructor
@Entity
@Table(name = "location")
public class Location {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "amount")
	private Integer amount;
	
	@Column(name = "price")
	private Integer price;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_event", nullable = true)
	private Event event;
	

	@OneToMany(mappedBy = "location",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Ticket>tickets;

	 
	public Location(String name, Integer amount, Integer price ) {
		super();
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.event = event;
	}
}
