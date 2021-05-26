package com.spring.service.user;

import com.spring.dto.model.UserDTO;
import com.spring.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Class ...
 * 
 * Title : 26 Reasons Why Using Optional Correctly Is Not Optional
 * {@link} https://dzone.com/articles/using-optional-correctly-is-not-optional
 * 
 * @since 19/05/2021
 *
 */
public interface UserService {


	/**
	 * Method  ... in database
	 * 
	 * @since 19/05/2021
	 * 
	 * @param user
	 * @return User object
	 */
	User save(User user);
	
	
	/**
	 * Method that find all users.
	 * 
	 * 
	 * @since 21/05/2021
	 * 
	 * @return <code>List<Travels></code> object
	 */
	List<UserDTO> findAll();
	
	
	/**
	 * Method tìm user bởi email trong database.
	 * 
	 
	 * @since 19/05/2021
	 * 
	 * @param email
	 * @return Optional<User> object
	 */
	Optional<UserDTO> findByEmail(String email);
	
	/**
	 * Method tìm user bởi id trong database.
	 * 
	 * @since 19/05/2021
	 * 
	 * @param email
	 * @return Optional<User> object
	 */
	Optional<UserDTO> findById(Long id);
	
}
