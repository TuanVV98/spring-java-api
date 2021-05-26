package com.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.User;


	/**
	 * Class JpaRepository 
	 * {@link} https://viblo.asia/p/java-springboot-spring-data-jpa-1-tong-quan-va-khai-niem-jvElayjDlkw
	 * 
	 * @author ABC
	 *
	 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	/**
	 * Method tìm kiếm User thông qua email
	 * 
	 * @since 19/05/2021
	 * 
	 * @param email
	 * @return Optional<User>
	 */
	Optional<User> findByEmail(String email);
	
	Optional<User> findById(Long id);
	
}
