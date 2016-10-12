package com.trinisalud.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.trinisalud.business.Role;
import com.trinisalud.repository.UserRepository;

@Component("securityService")
public class SecurityService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.trinisalud.domain.User user = userRepository.findOne(username);
		List<SimpleGrantedAuthority> roles = getListOfRoles(user);
		return new User(username, user.getPassword(), roles);
	}

	private List<SimpleGrantedAuthority> getListOfRoles(com.trinisalud.domain.User user) {
		List<SimpleGrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
		if (user.getRole().equals(Role.IPS_WORKER.toString())) {
			roles.add(new SimpleGrantedAuthority("ROLE_" + Role.CUSTOMER));
		}
		return roles;
	}

}
