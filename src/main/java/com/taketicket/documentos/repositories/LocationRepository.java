package com.taketicket.documentos.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.taketicket.documentos.models.entities.Location;

public interface LocationRepository extends ListCrudRepository<Location, UUID> {

	Location findOneByName(String name);
	
	List<Location> findByNameContaining (String name);
}
