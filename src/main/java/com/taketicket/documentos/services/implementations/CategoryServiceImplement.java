package com.taketicket.documentos.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taketicket.documentos.models.dtos.categories.SaveCategoryDTO;
import com.taketicket.documentos.models.dtos.categories.UpdateCategoryDTO;
import com.taketicket.documentos.models.entities.Category;
import com.taketicket.documentos.repositories.CategoryRepository;
import com.taketicket.documentos.services.CategoryService;

@Service
public class CategoryServiceImplement implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void save(SaveCategoryDTO categoryInfo) throws Exception {
		Category category = new Category(
				categoryInfo.getName());	
				
		categoryRepository.save(category);
	}
	
	@Override
	public void update(UpdateCategoryDTO categoryInfo) throws Exception {
		UUID _code = UUID.fromString(categoryInfo.getCode());
		Category category = categoryRepository.findById(_code).orElse(null);
		
		if ( category == null) return;
		
		category.setName(categoryInfo.getName());
		
		categoryRepository.save(category);
	}
	
	@Override
	public Category findOneById(String code) {
		try {
			UUID _code = UUID.fromString(code);
			return categoryRepository.findById(_code).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public void deleteOneById(String code) throws Exception {
		UUID _code = UUID.fromString(code);
		categoryRepository.deleteById(_code);
	}
	
	
	@Override
	public Category findOneByName(String name) {
		return categoryRepository.findOneByName(name);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> findFragmentName(String name) {
		return categoryRepository.findByNameContaining(name);
	}
}
