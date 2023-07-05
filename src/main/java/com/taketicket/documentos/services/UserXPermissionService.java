package com.taketicket.documentos.services;

import com.taketicket.documentos.models.entities.Permission;
import com.taketicket.documentos.models.entities.User;

public interface UserXPermissionService {
	
	void save(User user, Permission permission) throws Exception;
	void delete(String userCode, String PermissionCode)throws Exception;

}
