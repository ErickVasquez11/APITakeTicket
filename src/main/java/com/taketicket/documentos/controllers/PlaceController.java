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


import com.taketicket.documentos.models.dtos.places.PlaceAllDTO;
import com.taketicket.documentos.models.dtos.places.SavePlaceDTO;
import com.taketicket.documentos.models.dtos.places.UpdatePlaceDTO;
import com.taketicket.documentos.models.dtos.response.MessageDTO;
import com.taketicket.documentos.models.entities.Place;
import com.taketicket.documentos.services.PlaceService;
import com.taketicket.documentos.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/place/")
@CrossOrigin("*")
public class PlaceController {

	@Autowired
	private PlaceService placeService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	// ruta /place con el buscador
	
	@GetMapping("")
	public ResponseEntity<?> getPlaces(@RequestParam(required = false) String name) {
		if (name !=null && !name.isEmpty()) {
			List<Place> places = placeService.findFragmentName(name);
			List<PlaceAllDTO> placeAllDTOs = new ArrayList<>();
			
			for ( Place place : places) {
				PlaceAllDTO allDTO = new PlaceAllDTO(place.getCode(), place.getName());
				placeAllDTOs.add(allDTO);
			}
			return new ResponseEntity<>(placeAllDTOs, HttpStatus.OK);
		}	else {
			List<Place> places = placeService.findAll();
			List<PlaceAllDTO> placeAllDTOs = new ArrayList<>();
			for (Place place : places) {
				PlaceAllDTO allDTO = new PlaceAllDTO(place.getCode(), place.getName());
				placeAllDTOs.add(allDTO);
			}
			return new ResponseEntity<>(placeAllDTOs, HttpStatus.OK);
		}
	}
	
	// Buscar por el nombre la place
	@GetMapping("/{name}")
	public ResponseEntity<?> getPlaceByName(@PathVariable String name) {
		Place place = placeService.findOneByName(name);
		if (place == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(place, HttpStatus.OK);
	}

	// Buscar por el codigo de place
	@GetMapping("/code/{code}")
	public ResponseEntity<?> getPlaceByCode(@PathVariable String code) {
		Place place = placeService.findOneById(code);
		if ( place == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(place, HttpStatus.OK);
	}
	
	// Crear la place
		@PostMapping("")
		public ResponseEntity<?> createPlace(
				@ModelAttribute @Valid SavePlaceDTO data, BindingResult validations) {
			if (validations.hasErrors()) {
				return new ResponseEntity<>(errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
				
			}	try {
				placeService.save(data);
				return new ResponseEntity<>(new MessageDTO("Excellent! place created"), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		// Actualizar la categoria
		@PutMapping("/updateplace/")
		public ResponseEntity<?> updatePlace(
				@ModelAttribute @Valid UpdatePlaceDTO data, BindingResult validations) {
			if (validations.hasErrors()) {
				return new ResponseEntity<>(
						errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
			}
			Place place = placeService.findOneById(data.getCode());
			if (place == null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			try {
				placeService.update(data);
				return new ResponseEntity<>( new MessageDTO("Excellent! place updated"), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		// Eliminar la categoria
		@DeleteMapping("/{code}")
		public ResponseEntity<?> deletePlace(@PathVariable String code ) {
			Place place = placeService.findOneById(code);
			if (place == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			try {
				placeService.deleteOneById(code);
				return new ResponseEntity<>( new MessageDTO("Excellent! delete category"), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}
