package com.taketicket.documentos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.taketicket.documentos.models.dtos.permission.PermissionAllDTO;
import com.taketicket.documentos.models.dtos.permission.SavePermissionDTO;
import com.taketicket.documentos.models.dtos.permission.UpdatePermissionDTO;
import com.taketicket.documentos.models.dtos.response.MessageDTO;
import com.taketicket.documentos.models.entities.Permission;
import com.taketicket.documentos.services.PermissionService;
import com.taketicket.documentos.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/permission/")
@CrossOrigin("*")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	// all permission
	
	@GetMapping("")
	public ResponseEntity<?> getPermissions(@RequestParam(required = false) String type) {
		if (type != null && !type.isEmpty()) {
			List<Permission> permissions = permissionService.findFragmentType(type);
			List<PermissionAllDTO> permissionAllDTOs = new ArrayList<>();
			
			for (Permission permission : permissions) {
				PermissionAllDTO allDTO = new PermissionAllDTO(permission.getCode(), permission.getType());
				permissionAllDTOs.add(allDTO);
			}
			return new ResponseEntity<>(permissionAllDTOs, HttpStatus.OK);
		} else {
			List<Permission> permissions = permissionService.findAll();
			List<PermissionAllDTO> permissionAllDTOs = new ArrayList<>();
			for (Permission permission : permissions) {
				PermissionAllDTO allDTO = new PermissionAllDTO(permission.getCode(), permission.getType());
				permissionAllDTOs.add(allDTO);
		}
			return  new ResponseEntity<>(permissionAllDTOs, HttpStatus.OK);
	  }
		
	}
	
	
	//Crear el permiso
	@PostMapping("")
	public ResponseEntity<?> createPermission(
			@ModelAttribute @Valid SavePermissionDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
			
		}	try {
			permissionService.save(data);
			return new ResponseEntity<>(new MessageDTO("Excellent! category created"), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Actualizaz la permission
	@PutMapping("/updatepermission/")
	public ResponseEntity<?> updatePermission(
			@ModelAttribute @Valid UpdatePermissionDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(
					errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
		}
		Permission permission = permissionService.findOneById(data.getCode());
		if (permission == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		try {
			permissionService.update(data);
			return new ResponseEntity<>( new MessageDTO("Excellent! permission updated"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Eliminar la permission
		@DeleteMapping("/{code}")
		public ResponseEntity<?> deletePermission(@PathVariable String code ) {
			Permission permission = permissionService.findOneById(code);
			if (permission == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			try {
				permissionService.deleteOneById(code);
				return new ResponseEntity<>( new MessageDTO("Excellent! delete permission"), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
}
