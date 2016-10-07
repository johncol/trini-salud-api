package com.trinisalud.repository;

import org.springframework.data.repository.CrudRepository;

import com.trinisalud.domain.TriniSaludUser;

public interface TriniSaludUserRepository extends CrudRepository<TriniSaludUser, String> {

	TriniSaludUser findByUsername(String username);
	
	TriniSaludUser findByUsernameAndPassword(String username, String password);

}
