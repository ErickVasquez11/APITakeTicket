package com.taketicket.documentos.services;

import java.util.List;

import com.taketicket.documentos.models.dtos.event.SaveEventDTO;
import com.taketicket.documentos.models.dtos.event.UpdateEventDTO;
import com.taketicket.documentos.models.entities.Event;

public interface EventService {

	void save(SaveEventDTO eventInfo) throws Exception;
	void update(UpdateEventDTO eventInfo) throws Exception;
	void deleteOneById(String code) throws Exception;
	Event findOneById(String code);
	List<Event> findAll();
	List<Event> findFragmentTitle (String title);
}
