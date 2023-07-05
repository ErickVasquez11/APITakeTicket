package com.taketicket.documentos.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.taketicket.documentos.models.dtos.response.MessageDTO;
import com.taketicket.documentos.models.dtos.users.RegisterUserDTO;
import com.taketicket.documentos.models.dtos.users.UpdateUserDTO;
import com.taketicket.documentos.models.entities.User;
import com.taketicket.documentos.services.UserService;
import com.taketicket.documentos.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	//
	@PostMapping("/auth/singup")
	public ResponseEntity<?> register(
			@ModelAttribute @Valid RegisterUserDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(
					errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
		}
		try {
			userService.save(data);
			return new ResponseEntity<>(new MessageDTO("Excellent! user created"), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(new MessageDTO("Warn! User duplicate"), HttpStatus.CONFLICT);
		}
	}
	
	// ALL User
	@GetMapping("")
	public ResponseEntity<?> getUsers() {
		List<User> users = userService.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	//Update User error
	
	@PutMapping("/updateuser/")
	public ResponseEntity<?> updateUser(
			@ModelAttribute @Valid UpdateUserDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(
					errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
		}
		User user  = userService.findOneById(data.getCode());
		if (user == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		try {
			userService.update(data);
			return new ResponseEntity<>( new MessageDTO("Excellent! place updated"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Eliminar el usuario
			@DeleteMapping("/{code}")
			public ResponseEntity<?> deleteUser(@PathVariable String code ) {
				User user = userService.findOneById(null);
				if (user == null)
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				try {
					userService.deleteByOneId(code);
					return new ResponseEntity<>( new MessageDTO("Excellent! delete category"), HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
}
