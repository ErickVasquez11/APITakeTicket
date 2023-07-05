package com.taketicket.documentos.models.dtos.userxpermission;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveUserXPermissionDTO {

	@NotBlank(message = "User code is required")
	private String Usercode;
	
	
}
