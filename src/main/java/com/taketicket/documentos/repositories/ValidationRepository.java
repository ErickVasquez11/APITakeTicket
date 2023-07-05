package com.taketicket.documentos.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.taketicket.documentos.models.entities.Validation;

public interface ValidationRepository extends ListCrudRepository<Validation, UUID>{
	
	Validation findOneByState (Boolean state);
	
	List<Validation> findByStateContaining (Boolean state);

}
