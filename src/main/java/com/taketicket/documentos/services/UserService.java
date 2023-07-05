package com.taketicket.documentos.services;

import java.util.List;
import java.util.UUID;

import com.taketicket.documentos.models.dtos.users.RegisterUserDTO;
import com.taketicket.documentos.models.dtos.users.UpdateUserDTO;
import com.taketicket.documentos.models.entities.User;



public interface UserService {
	void save(RegisterUserDTO userInfo) throws Exception;
	void update(UpdateUserDTO userInfo) throws Exception;
	void deleteByOneId(String code) throws Exception;
	User findOneById(UUID code);
	User findOneByName(String name);
	List<User> findAll();
	
	User findOneByNameOrEmail( String userData);


}
