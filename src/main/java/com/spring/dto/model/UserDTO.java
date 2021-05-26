package com.spring.dto.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.entity.User;
import com.spring.util.security.BcryptUtil;

import lombok.*;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO extends RepresentationModel<UserDTO>{

	@Getter
	@NotNull
	private Long id;
	
	@Getter
	@NotNull
	private String name;
	
	@Getter
	@Email(message="Invalid email.")
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	@Pattern(regexp="^(ROLE_ADMIN|ROLE_USER)$", 
			message="role only the values ROLE_ADMIN or ROLE_USER are accepted.")
	private String role;
	
	@Null
	private String delete_at;
	
	@Null
	private String delete_user;
	
	public UserDTO (Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}
	

	public String getPassword() {
		return BcryptUtil.getHash(this.password);
	}
	
	/**
	 * Method to convert an User DTO to an User entity
	 * 
	 * @since 19/05/2021
	 * 
	 * @param dto
	 * @return an User object
	 */
	public User convertDTOToEntity() {
		return new ModelMapper().map(this, User.class);
	}
}
