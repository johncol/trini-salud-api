package com.trinisalud.repository;

import org.springframework.data.repository.CrudRepository;

import com.trinisalud.domain.User;

public interface UserRepository extends CrudRepository<User, String> {

	User findByUsername(String username);

}
