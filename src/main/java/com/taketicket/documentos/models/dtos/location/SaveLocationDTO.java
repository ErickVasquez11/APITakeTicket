package com.taketicket.documentos.models.dtos.location;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveLocationDTO {

	@NotBlank(message = "Warn! name is required")
	private String name;
	
	@Min(value = 0, message = "El monto debe ser mayor o igual a cero")
	private Integer amount;
	
	@Min(value = 0, message = "El monto debe ser mayor o igual a cero")
	private Integer price;
}
