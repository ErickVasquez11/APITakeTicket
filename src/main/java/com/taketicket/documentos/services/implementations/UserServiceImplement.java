package com.taketicket.documentos.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.taketicket.documentos.models.dtos.users.RegisterUserDTO;
import com.taketicket.documentos.models.dtos.users.UpdateUserDTO;
import com.taketicket.documentos.models.entities.User;
import com.taketicket.documentos.repositories.UserRepository;
import com.taketicket.documentos.services.UserService;

@Service
public class UserServiceImplement implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void save(RegisterUserDTO userInfo) throws Exception {
		User user = new User(
				userInfo.getName(),
				userInfo.getEmail(),
				userInfo.getPassword()
				);
		userRepository.save(user);
				
	}
	
	@Override
	public void update(UpdateUserDTO userInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}


	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	

	@Override
	public User findOneByNameOrEmail(String userData) {
		
		return userRepository.findOneByNameOrEmail(userData, userData);
	}

	@Override
	public void deleteByOneId(String code) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findOneByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOneById(UUID code) {
		// TODO Auto-generated method stub
		return null;
	}




	
}
