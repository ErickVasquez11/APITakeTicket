package com.taketicket.documentos.models.dtos.categories;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCategoryDTO {

	@NotBlank(message = "Warn! code is required")
	private String code;
	
	@NotBlank(message = "Warn! title is required")
	private String name;
	
}
