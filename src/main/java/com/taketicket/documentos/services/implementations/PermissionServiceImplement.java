package com.taketicket.documentos.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.taketicket.documentos.models.dtos.permission.SavePermissionDTO;
import com.taketicket.documentos.models.dtos.permission.UpdatePermissionDTO;
import com.taketicket.documentos.models.entities.Permission;
import com.taketicket.documentos.repositories.PermissionRepository;
import com.taketicket.documentos.services.PermissionService;

@Service
public class PermissionServiceImplement implements PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;
	
	@Override
	public void save(SavePermissionDTO permissionInfo) throws Exception {
		Permission permission  = new Permission(
				permissionInfo.getType());	
				
		permissionRepository.save(permission);
	}
	
	@Override
	public void update(UpdatePermissionDTO permissionInfo) throws Exception {
		UUID _code = UUID.fromString(permissionInfo.getCode());
		Permission permission = permissionRepository.findById(_code).orElse(null);
		
		if (permission == null ) return;
		
		permission.setType(permissionInfo.getType());
		
		permissionRepository.save(permission);
	}
	
	@Override
	public Permission findOneById(String code) {
		try {
			UUID _code = UUID.fromString(code);
			return permissionRepository.findById(_code).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public void deleteOneById(String code) throws Exception {
		UUID _code = UUID.fromString(code);
		permissionRepository.deleteById(_code);
	}
	
	@Override
	public Permission findOneByType(String type) {
		return permissionRepository.findOneByType(type);
	}
	
	@Override
	public List<Permission> findAll() {
		return permissionRepository.findAll();
	}
	
	@Override
	public List<Permission> findFragmentType (String type) {
		return permissionRepository.findByTypeContaining(type);
	}
}
