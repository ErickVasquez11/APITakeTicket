package com.taketicket.documentos.models.dtos.places;

import java.util.UUID;

import lombok.Data;

@Data
public class PlaceAllDTO {

	private UUID id;
	private String name;
	
	public PlaceAllDTO(UUID id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
