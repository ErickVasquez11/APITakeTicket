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

import com.taketicket.documentos.models.dtos.categories.CategoryAllDTO;
import com.taketicket.documentos.models.dtos.categories.SaveCategoryDTO;
import com.taketicket.documentos.models.dtos.categories.UpdateCategoryDTO;
import com.taketicket.documentos.models.dtos.response.MessageDTO;
import com.taketicket.documentos.models.entities.Category;
import com.taketicket.documentos.services.CategoryService;

import jakarta.validation.Valid;
import com.taketicket.documentos.utils.RequestErrorHandler;

@RestController
@RequestMapping("/category/")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	//ruta /category con el buscador
	
	@GetMapping("")
	public ResponseEntity<?> getCategories(@RequestParam(required = false ) String name) {
		if (name != null && !name.isEmpty()) {
			List<Category> categories = categoryService.findFragmentName(name);
			List<CategoryAllDTO> categoryAllDTOs = new ArrayList<>();
			
			for (Category category : categories) {
				CategoryAllDTO allDTO = new CategoryAllDTO(category.getCode(), category.getName());
				categoryAllDTOs.add(allDTO);
			}
			return new ResponseEntity<>(categoryAllDTOs, HttpStatus.OK);
		}	else {
			List<Category> categories = categoryService.findAll();
			List<CategoryAllDTO> categoryAllDTOs = new ArrayList<>();
			for (Category category : categories) {
				CategoryAllDTO allDTO = new CategoryAllDTO(category.getCode(), category.getName());
				categoryAllDTOs.add(allDTO);
			}
			return new ResponseEntity<>(categoryAllDTOs, HttpStatus.OK);
		}
	}
	
	// Buscar por el nombre de la categoria
	@GetMapping("/{name}") 
	public ResponseEntity<?> getCategoryByName(@PathVariable String name) {
		Category category = categoryService.findOneByName(name);
		if ( category == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}
	
	// Buscar por el codigo de la categoria
	@GetMapping("/code/{code}")
	public ResponseEntity<?> getCategoryByCode(@PathVariable String code) {
		Category category = categoryService.findOneById(code);
		if ( category == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}
	
	// Crear la categoria
	@PostMapping("")
	public ResponseEntity<?> createCategory(
			@ModelAttribute @Valid SaveCategoryDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
			
		}	try {
			categoryService.save(data);
			return new ResponseEntity<>(new MessageDTO("Excellent! category created"), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Actualizar la categoria
	@PutMapping("/updatecategory/")
	public ResponseEntity<?> updateCategory(
			@ModelAttribute @Valid UpdateCategoryDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(
					errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
		}
		Category category = categoryService.findOneById(data.getCode());
		if (category == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		try {
			categoryService.update(data);
			return new ResponseEntity<>( new MessageDTO("Excellent! category updated"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Eliminar la categoria
	@DeleteMapping("/{code}")
	public ResponseEntity<?> deleteCategory(@PathVariable String code ) {
		Category category = categoryService.findOneById(code);
		if (category == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		try {
			categoryService.deleteOneById(code);
			return new ResponseEntity<>( new MessageDTO("Excellent! delete category"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
