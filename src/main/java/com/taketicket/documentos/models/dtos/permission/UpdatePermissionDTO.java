package com.taketicket.documentos.models.dtos.permission;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdatePermissionDTO {

	@NotBlank(message = "Warn! code is required")
	private String code;
	
	@NotBlank(message = "Warn! type is required")
	private String type;
}
