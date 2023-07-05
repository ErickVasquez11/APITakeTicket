package com.taketicket.documentos.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.taketicket.documentos.models.entities.Event;

public interface EventRepository  extends ListCrudRepository<Event, UUID>{
	
	Event findOneByTitle (String title);
	
	List<Event> findByTitleContaining (String title);

}
