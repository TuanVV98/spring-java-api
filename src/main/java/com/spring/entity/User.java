package com.spring.entity;

import java.io.Serializable;


import javax.persistence.*;

import org.modelmapper.ModelMapper;

import com.spring.dto.model.UserDTO;
import com.spring.enumeration.RoleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User implements Serializable{
	
	/**
	 * Khả năng tuần tự hóa của 1 lớp
	 * 
	 * https://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html
	 */
	private static final long serialVersionUID = 5514528747731992863L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private RoleEnum role;
	
	@Column(name = "delete_at")
	private String delete_at;
	
	@Column(name = "delete_user")
	private String delete_user;
	
	
	/**
	 * Method xác nhận user là admin
	 * 
	 * return boolean
	 */
	public boolean isAdmin() {
		return RoleEnum.ROLE_ADMIN.toString().equals(this.role.toString());
	}


	/**
	 * Method to convert an User entity to an User DTO
	 * 
	 * @since 19/05/2021
	 * 
	 * @param dto
	 * @return an UserDTO object
	 */
	public UserDTO converEntityToDTO() {
		return new ModelMapper().map(this, UserDTO.class);
	}
	
}
