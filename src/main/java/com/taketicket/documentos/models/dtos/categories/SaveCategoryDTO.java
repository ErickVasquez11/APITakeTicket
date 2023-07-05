package com.taketicket.documentos.models.dtos.categories;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveCategoryDTO {
	
	@NotBlank(message = "Warn! name is required")
	private String name;
}
