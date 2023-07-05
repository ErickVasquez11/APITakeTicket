package com.taketicket.documentos.models.dtos.location;

import java.util.UUID;

import lombok.Data;

@Data
public class LocationAllDTO {

	private UUID id;
	private String name;
	private Integer amount;
	private Integer price;
	
	public LocationAllDTO(UUID id, String name, Integer amount, Integer price) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.price = price;
	}
}
