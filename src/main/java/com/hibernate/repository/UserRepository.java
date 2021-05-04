package com.hibernate.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.entity.User;

public interface UserRepository extends CrudRepository<User, Long>
{	
	User findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE User SET name = ?2,password=?3 WHERE id = ?1")
	void updateById(Long id, String name, String password);
}