package com.taketicket.documentos.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taketicket.documentos.models.dtos.location.SaveLocationDTO;
import com.taketicket.documentos.models.dtos.location.UpdateLocationDTO;

import com.taketicket.documentos.models.entities.Location;
import com.taketicket.documentos.repositories.LocationRepository;
import com.taketicket.documentos.services.LocationService;


@Service
public class LocationServiceImplement implements LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public void save(SaveLocationDTO locationInfo) throws Exception {
		Location location = new Location(
				locationInfo.getName(),
				locationInfo.getAmount(),
				locationInfo.getPrice());
		
		locationRepository.save(location);
		
	}
	
	@Override 
	public void update(UpdateLocationDTO locationInfo) throws Exception {
		UUID _code = UUID.fromString(locationInfo.getCode());
		Location location = locationRepository.findById(_code).orElse(null);
		
		if ( location == null ) return;
		location.setName(locationInfo.getName());
		
		locationRepository.save(location);
	}
	
	@Override
	public Location findOneById(String code) {
		try {
			UUID _code = UUID.fromString(code);
			return locationRepository.findById(_code).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public void deleteOneById(String code) throws Exception {
		UUID _code = UUID.fromString(code);
		locationRepository.deleteById(_code);
	}
	
	
	@Override
	public Location findOneByName(String name) {
		return locationRepository.findOneByName(name);
	}

	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	@Override
	public List<Location> findFragmentName(String name) {
		return locationRepository.findByNameContaining(name);
	}
}
