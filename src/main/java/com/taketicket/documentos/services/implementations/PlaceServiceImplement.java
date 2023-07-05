package com.taketicket.documentos.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.taketicket.documentos.models.dtos.places.SavePlaceDTO;
import com.taketicket.documentos.models.dtos.places.UpdatePlaceDTO;
import com.taketicket.documentos.models.entities.Place;
import com.taketicket.documentos.repositories.PlaceRepository;
import com.taketicket.documentos.services.PlaceService;

@Service
public class PlaceServiceImplement implements PlaceService {

	@Autowired
	private PlaceRepository placeRepository;
	
	@Override
	public void save(SavePlaceDTO placeInfo) throws Exception {
		Place place = new Place(
				placeInfo.getName());	
				
		placeRepository.save(place);
	}
	
	@Override
	public void update(UpdatePlaceDTO placeInfo) throws Exception {
		UUID _code = UUID.fromString(placeInfo.getCode());
		Place place = placeRepository.findById(_code).orElse(null);
		
		if ( place == null) return;
		
		place.setName(placeInfo.getName());
		
		placeRepository.save(place);
	}
	
	@Override
	public Place findOneById(String code) {
		try {
			UUID _code = UUID.fromString(code);
			return placeRepository.findById(_code).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public void deleteOneById(String code) throws Exception {
		UUID _code = UUID.fromString(code);
		placeRepository.deleteById(_code);
	}
	
	
	@Override
	public Place findOneByName(String name) {
		return placeRepository.findOneByName(name);
	}

	@Override
	public List<Place> findAll() {
		return placeRepository.findAll();
	}

	@Override
	public List<Place> findFragmentName(String name) {
		return placeRepository.findByNameContaining(name);
	}
}
