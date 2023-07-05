package com.taketicket.documentos.models.dtos.permission;

import java.util.UUID;

import lombok.Data;

@Data
public class PermissionAllDTO {

	private UUID id;
	private String type;
	
	public PermissionAllDTO(UUID id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
}
