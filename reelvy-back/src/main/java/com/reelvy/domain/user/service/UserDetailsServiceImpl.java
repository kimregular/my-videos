package com.reelvy.domain.user.service;

import com.reelvy.domain.user.repository.UserRepository;
import com.reelvy.domain.user.entity.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new UserDetailsImpl(userRepository
				                      .findByUsername(username)
				                      .orElseThrow(() -> new UsernameNotFoundException("No user has found")));
	}
}
