package com.taketicket.documentos.models.dtos.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class SaveValidationDTO {

	@NotNull(message = "Error! state is required")
	private Boolean state;
	
	@NotNull(message = "Error! date emit is required")
	private java.sql.Timestamp date_emit;
	
	@NotNull(message = "Error! date recived is required")
	private java.sql.Timestamp date_recived;
	
	@NotBlank(message = "Error! hash is required")
	private String hash;
}


