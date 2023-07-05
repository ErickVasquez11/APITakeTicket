package com.taketicket.documentos.models.dtos.validation;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateValidationDTO {

	@NotBlank(message = "Warn! code is required")
	private String code;
	
	@NotNull(message = "Warn! state is required")
	private Boolean state;
	
	
	@NotNull(message = "Error! date emit is required")
	private java.sql.Timestamp date_emit;
	
	@NotNull(message = "Error! date recived is required")
	private java.sql.Timestamp date_recived;

	@NotBlank(message = "Warn! hash is required")
	private String hash;
}
