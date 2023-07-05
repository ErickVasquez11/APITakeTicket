package com.taketicket.documentos.models.dtos.validation;


import java.util.UUID;

import lombok.Data;

@Data
public class ValidationAllDTO {

	private UUID id;
	private Boolean state;
	private java.sql.Timestamp date_emit;
	private java.sql.Timestamp date_recived;
	private String hash;
	
	public ValidationAllDTO(UUID id, Boolean state, java.sql.Timestamp date_emit, java.sql.Timestamp date_recived, String hash ) {
		super();
		this.id = id;
		this.state = state;
		this.date_emit = date_emit;
		this.date_recived = date_recived;
		this.hash = hash;
	}
	
}
