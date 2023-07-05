package com.taketicket.documentos.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.taketicket.documentos.models.entities.Place;

public interface PlaceRepository  extends ListCrudRepository<Place, UUID>{

	Place findOneByName(String name);
	
	List<Place> findByNameContaining (String name);
}
