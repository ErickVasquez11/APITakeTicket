package com.taketicket.documentos.services;

import java.util.List;

import com.taketicket.documentos.models.dtos.validation.SaveValidationDTO;
import com.taketicket.documentos.models.dtos.validation.UpdateValidationDTO;
import com.taketicket.documentos.models.entities.Validation;

public interface ValidationService {

	void save(SaveValidationDTO validationInfo) throws Exception;
	void update(UpdateValidationDTO validationInfo) throws Exception;
	void deleteOneById(String code) throws Exception;
	Validation findOneById(String code);
	Validation findOneByState(Boolean state);
	List<Validation> findAll();
	
	List<Validation> findFragementState (Boolean state);
}
