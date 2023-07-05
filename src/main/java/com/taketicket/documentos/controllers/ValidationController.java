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

import com.taketicket.documentos.models.dtos.categories.UpdateCategoryDTO;
import com.taketicket.documentos.models.dtos.response.MessageDTO;
import com.taketicket.documentos.models.dtos.validation.SaveValidationDTO;
import com.taketicket.documentos.models.dtos.validation.UpdateValidationDTO;
import com.taketicket.documentos.models.dtos.validation.ValidationAllDTO;
import com.taketicket.documentos.models.entities.Category;
import com.taketicket.documentos.models.entities.Validation;
import com.taketicket.documentos.services.ValidationService;
import com.taketicket.documentos.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/validation/")
@CrossOrigin("*")
public class ValidationController {

	@Autowired
	private ValidationService validationService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	@GetMapping("")
	public ResponseEntity<?> getValidations(@RequestParam(required= false) Boolean state) {
		if (state != null && !state) {
			List<Validation> validations = validationService.findFragementState(state);
			List<ValidationAllDTO> validationAllDTOs = new ArrayList<>();
			
			for ( Validation validation : validations) {
				ValidationAllDTO allDTO = new ValidationAllDTO(validation.getCode(), validation.getState(), validation.getDate_emit(), validation.getDate_received(), validation.getHash());
				validationAllDTOs.add(allDTO);
			}
			return new ResponseEntity<>(validationAllDTOs, HttpStatus.OK);
		} else {
			List<Validation> validations = validationService.findAll();
			List<ValidationAllDTO> validationAllDTOs = new ArrayList<>();
			for ( Validation validation : validations) {
				ValidationAllDTO allDTO = new ValidationAllDTO(validation.getCode(), validation.getState(), validation.getDate_emit(), validation.getDate_received(), validation.getHash());
				validationAllDTOs.add(allDTO);
		}
			 return new ResponseEntity<>(validationAllDTOs, HttpStatus.OK);
	}
  }
	
	// create validation
	@PostMapping("")
	public ResponseEntity<?> createValidation(
			@ModelAttribute @Valid SaveValidationDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
			
		}	try {
			validationService.save(data);
			return new ResponseEntity<>(new MessageDTO("Excellent! validation created"), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Update Validation
	@PutMapping("/updatevalidation/")
	public ResponseEntity<?> updateValidation(
			@ModelAttribute @Valid UpdateValidationDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(
					errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
		}
		Validation validation = validationService.findOneById(data.getCode());
		if (validation == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		try {
			validationService.update(data);
			return new ResponseEntity<>( new MessageDTO("Excellent! validation updated"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Delete validation 
	@DeleteMapping("/{code}")
	public ResponseEntity<?> deleteValidation(@PathVariable String code ) {
		Validation validation = validationService.findOneById(code);
		if (validation == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		try {
			validationService.deleteOneById(code);
			return new ResponseEntity<>( new MessageDTO("Excellent! delete validation"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
