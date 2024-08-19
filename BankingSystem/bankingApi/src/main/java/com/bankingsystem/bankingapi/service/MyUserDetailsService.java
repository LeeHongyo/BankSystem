package com.bankingsystem.bankingapi.service;

import com.bankingsystem.bankingdb.entity.UserEntity;
import com.bankingsystem.bankingdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
    }
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getRoles());
  }
}
