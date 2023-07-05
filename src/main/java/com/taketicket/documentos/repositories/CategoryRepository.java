package com.taketicket.documentos.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.taketicket.documentos.models.entities.Category;

public interface CategoryRepository extends ListCrudRepository<Category, UUID> {

	Category findOneByName(String name);
	
	List<Category> findByNameContaining (String name);
}
