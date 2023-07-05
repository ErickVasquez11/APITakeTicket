package com.taketicket.documentos.services;

import java.util.List;

import com.taketicket.documentos.models.dtos.location.SaveLocationDTO;
import com.taketicket.documentos.models.dtos.location.UpdateLocationDTO;
import com.taketicket.documentos.models.entities.Location;

public interface LocationService {

	void save(SaveLocationDTO locationInfo) throws Exception;
	void update(UpdateLocationDTO locationInfo) throws Exception;
	void deleteOneById( String code) throws Exception;
	Location findOneById(String code);
	Location findOneByName(String name);
	List<Location> findAll();
	
	List<Location> findFragmentName(String name);
}
