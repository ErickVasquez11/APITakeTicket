package com.taketicket.documentos.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.taketicket.documentos.models.entities.Permission;

public interface PermissionRepository extends ListCrudRepository<Permission, UUID>{
	
	Permission findOneByType(String type);
	
	List<Permission> findByTypeContaining (String type);



}
