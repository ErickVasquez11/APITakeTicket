package com.taketicket.documentos.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taketicket.documentos.models.dtos.validation.SaveValidationDTO;
import com.taketicket.documentos.models.dtos.validation.UpdateValidationDTO;
import com.taketicket.documentos.models.entities.Validation;
import com.taketicket.documentos.repositories.ValidationRepository;
import com.taketicket.documentos.services.ValidationService;

@Service
public class ValidationServiceImplement implements ValidationService{
	
	@Autowired
	private ValidationRepository validationRepository;
	
	@Override
	public void save(SaveValidationDTO validationInfo) throws Exception {
		Validation validation = new Validation(
				validationInfo.getState(),
				validationInfo.getDate_emit(),
				validationInfo.getDate_recived(),
				validationInfo.getHash()
				);
		validationRepository.save(validation);
	}
	
	@Override
	public void update(UpdateValidationDTO validationInfo) throws Exception {
		UUID _code = UUID.fromString(validationInfo.getCode());
		Validation validation = validationRepository.findById(_code).orElse(null);
		if (validation == null) return;
		validation.setState(validationInfo.getState());
		
		validationRepository.save(validation);
	}
	
	@Override
	public Validation findOneById(String code) {
		try {
			UUID _code = UUID.fromString(code);
			return validationRepository.findById(_code).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public void deleteOneById(String code) throws Exception {
		UUID _code = UUID.fromString(code);
		validationRepository.deleteById(_code);
	}
	
	@Override
	public Validation findOneByState(Boolean state) {
		return validationRepository.findOneByState(state);
	}
	
	@Override
	public List<Validation> findAll() {
		return validationRepository.findAll();
	}
	
	@Override
	public List<Validation> findFragementState(Boolean state) {
		return validationRepository.findByStateContaining(state);
	}
}
