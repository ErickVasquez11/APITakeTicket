package com.taketicket.documentos.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.taketicket.documentos.models.entities.UserXPermission;

public interface UserXPermissionRepository extends ListCrudRepository<UserXPermission, UUID> {

	
}
