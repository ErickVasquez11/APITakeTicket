package com.taketicket.documentos.models.dtos.location;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateLocationDTO {

	@NotBlank(message = "Warn! Code is required")
	private String code;
	
	@NotBlank(message = "Warn! name is required")
	private String name;
	
	@NotBlank(message = "Warn! amount is required")
	private Integer amount;
	
	@NotBlank(message = "Warn! price is required")
	private Integer price;
}
