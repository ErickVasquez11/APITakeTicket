package com.taketicket.documentos.services;

import java.util.List;

import com.taketicket.documentos.models.dtos.permission.SavePermissionDTO;
import com.taketicket.documentos.models.dtos.permission.UpdatePermissionDTO;
import com.taketicket.documentos.models.entities.Permission;

public interface PermissionService {

	void save(SavePermissionDTO permissionInfo) throws Exception;
	void update(UpdatePermissionDTO permissionInfo) throws Exception;
	void deleteOneById(String code) throws Exception;
	Permission findOneById(String code);
	Permission findOneByType(String type);
	List<Permission> findAll();
	
	List<Permission> findFragmentType(String type);
}
