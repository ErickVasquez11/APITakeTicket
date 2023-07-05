package com.taketicket.documentos.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;

import com.taketicket.documentos.models.entities.Permission;
import com.taketicket.documentos.models.entities.User;
import com.taketicket.documentos.models.entities.UserXPermission;
import com.taketicket.documentos.repositories.UserXPermissionRepository;
import com.taketicket.documentos.services.UserXPermissionService;

public class UserXPermissionImplement implements UserXPermissionService{
	
	@Autowired
	private UserXPermissionRepository repository;
	
	@Override 
	public void save(User user, Permission permission) throws Exception {
		UserXPermission relation = new UserXPermission(user, permission);
		repository.save(relation);
	}

	@Override
	public void delete(String userCode, String PermissionCode) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
