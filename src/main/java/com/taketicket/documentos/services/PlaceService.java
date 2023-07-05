package com.taketicket.documentos.services;

import java.util.List;

import com.taketicket.documentos.models.dtos.places.SavePlaceDTO;
import com.taketicket.documentos.models.dtos.places.UpdatePlaceDTO;
import com.taketicket.documentos.models.entities.Place;

public interface PlaceService {
	
	void save(SavePlaceDTO placeInfo) throws Exception;
	void update(UpdatePlaceDTO placeInfo) throws Exception;
	void deleteOneById(String code) throws Exception;
	Place findOneById(String code);
	Place findOneByName(String name);
	List<Place> findAll();
	
	List<Place> findFragmentName(String name);
}
