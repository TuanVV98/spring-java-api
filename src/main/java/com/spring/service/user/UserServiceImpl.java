package com.spring.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.model.UserDTO;
import com.spring.entity.User;
import com.spring.repository.UserRepository;
import com.spring.util.modelmapper.MapperUtil;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;
	
	/**
	 * @see UserService#save(User)
	 */
	@Override
	public User save(User user) {
		
		return repository.save(user);
	}

	/**
	 * @see UserService#findByEmail(String)
	 */
	@Override
	public Optional<UserDTO> findByEmail(String email) {
		Optional<User> user = repository.findByEmail(email);
		if(user.isPresent()) {
			return user.map(t->t.converEntityToDTO());
		}else {
		return Optional.empty();
		}
	}

	/**
	 * @see UserService#findAll()
	 */
	@Override
	public List<UserDTO> findAll() {
		return MapperUtil.mapList(repository.findAll(), UserDTO.class);
	}

	/**
	 * @see UserService#findById()
	 * 
	 * Title Java convert one optional type to another optional type
	 * {@link} https://stackoverflow.com/questions/52953120/java-convert-one-optional-type-to-another-optional-type
	 */
	@Override
	public Optional<UserDTO> findById(Long id) {
		Optional<User> user  = repository.findById(id);
		if(user.isPresent()) {
			return user.map(t ->t.converEntityToDTO());
			
		}else {
			return Optional.empty();
		}
		
	}

}
