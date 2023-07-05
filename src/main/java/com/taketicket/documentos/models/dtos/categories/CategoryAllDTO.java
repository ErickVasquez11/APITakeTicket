package com.taketicket.documentos.models.dtos.categories;

import java.util.UUID;

import lombok.Data;

@Data
public class CategoryAllDTO {
	
	private UUID id;
	private String name;
	
	public CategoryAllDTO(UUID id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
