package com.taketicket.documentos.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.taketicket.documentos.models.entities.User;

public interface UserRepository extends ListCrudRepository<User, UUID> {
	User findOneByNameOrEmail( String name, String email);

}
