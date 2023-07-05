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


import com.taketicket.documentos.models.dtos.location.LocationAllDTO;
import com.taketicket.documentos.models.dtos.location.SaveLocationDTO;
import com.taketicket.documentos.models.dtos.location.UpdateLocationDTO;
import com.taketicket.documentos.models.dtos.response.MessageDTO;

import com.taketicket.documentos.models.entities.Location;
import com.taketicket.documentos.services.LocationService;
import com.taketicket.documentos.utils.RequestErrorHandler;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/location/")
@CrossOrigin("*")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private RequestErrorHandler  errorHandler;
	
	
	// Obtener las location
	@GetMapping("")
	public ResponseEntity<?> getLocations(@RequestParam(required = false) String name) {
		if (name != null && !name.isEmpty()) {
			List<Location> locations = locationService.findFragmentName(name);
			List<LocationAllDTO> locationAllDTOs = new ArrayList<>();
			
			for (Location location : locations) {
				LocationAllDTO allDTO = new LocationAllDTO(location.getCode(), location.getName(), location.getPrice(), location.getAmount());
				locationAllDTOs.add(allDTO);
			}
			return new ResponseEntity<>(locationAllDTOs, HttpStatus.OK);
		} else {
			List<Location> locations = locationService.findAll();
			List<LocationAllDTO> locationAllDTOs = new ArrayList<>();
			for (Location location : locations) {
				LocationAllDTO allDTO = new LocationAllDTO(location.getCode(), location.getName(), location.getPrice(), location.getAmount());
				locationAllDTOs.add(allDTO);
			}
			return new ResponseEntity<>(locationAllDTOs, HttpStatus.OK);
		}
	}

	
	// Buscar por el nombre de la location
	
	@GetMapping("/{name}")
	public ResponseEntity<?> getLocationByName(@PathVariable String name) {
		Location location = locationService.findOneByName(name);
		if ( location == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(location, HttpStatus.OK);
	}
	
	// Buscar por el codigo de la location
		@GetMapping("/code/{code}")
		public ResponseEntity<?> getLocationByCode(@PathVariable String code) {
			Location location = locationService.findOneById(code);
			if ( location  == null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(location, HttpStatus.OK);
		}
		
		// Crear la location 
		@PostMapping("")
		public ResponseEntity<?> createLocation(
				@ModelAttribute @Valid SaveLocationDTO data, BindingResult validations) {
			if (validations.hasErrors()) {
				return new ResponseEntity<>(errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
				
			}	try {
				locationService.save(data);
				return new ResponseEntity<>(new MessageDTO("Excellent! location created"), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}	
		
		// Actualizar la location
		@PutMapping("/updatelocation/")
		public ResponseEntity<?> updateLocation(
				@ModelAttribute @Valid UpdateLocationDTO data, BindingResult validations) {
			if (validations.hasErrors()) {
				return new ResponseEntity<>(
						errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
			}
			Location location = locationService.findOneById(data.getCode());
			if (location == null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			try {
				locationService.update(data);
				return new ResponseEntity<>( new MessageDTO("Excellent! location updated"), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		// Eliminar la location
		@DeleteMapping("/{code}")
		public ResponseEntity<?> deleteLocation(@PathVariable String code ) {
			Location location = locationService.findOneById(code);
			if (location == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			try {
				locationService.deleteOneById(code);
				return new ResponseEntity<>( new MessageDTO("Excellent! delete location"), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

}
