package com.trinisalud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import com.trinisalud.domain.User;

@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface UserRepository extends CrudRepository<User, String> {

	User findByUsernameAndPassword(String username, String password);

}
