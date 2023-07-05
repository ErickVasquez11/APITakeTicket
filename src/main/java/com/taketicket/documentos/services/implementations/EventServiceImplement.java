package com.taketicket.documentos.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taketicket.documentos.models.dtos.event.SaveEventDTO;
import com.taketicket.documentos.models.dtos.event.UpdateEventDTO;
import com.taketicket.documentos.models.entities.Event;
import com.taketicket.documentos.repositories.EventRepository;
import com.taketicket.documentos.services.EventService;

@Service
public class EventServiceImplement implements EventService{
	
	@Autowired
	private EventRepository eventRepository;
	
	
	@Override
	public void save(SaveEventDTO eventInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/*
	@Override
	public void save(SaveEventDTO eventInfo) throws Exception {
		Event event = new Event(
				eventInfo.getTitle(),
				eventInfo.getInvolved(),
				eventInfo.getDate(),
				eventInfo.getDuration(),
				eventInfo.getSponsor(),
				eventInfo.getActive(),
				eventInfo.getCategory(),
				eventInfo.getPlace(),
				eventInfo.getUser(),
				eventInfo.getLocations(),
				eventInfo.getTickets());
		
		eventRepository.save(event);
	}
	*/
	@Override
	public void update(UpdateEventDTO eventInfo) throws Exception {
	
		
	}

	@Override
	public void deleteOneById(String code) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Event findOneById(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> findFragmentTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
