package com.taketicket.documentos.services;

import java.util.List;

import com.taketicket.documentos.models.dtos.categories.SaveCategoryDTO;
import com.taketicket.documentos.models.dtos.categories.UpdateCategoryDTO;
import com.taketicket.documentos.models.entities.Category;

public interface CategoryService {

	void save(SaveCategoryDTO categoryInfo) throws Exception;
	void update(UpdateCategoryDTO categoryInfo) throws Exception;
	void deleteOneById(String code) throws Exception;
	Category findOneById(String code);
	Category findOneByName(String name);
	List<Category> findAll();
	
	List<Category> findFragmentName(String name);
	

}
