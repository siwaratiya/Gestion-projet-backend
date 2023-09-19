package com.example.yyyyyy.Services;


import com.example.yyyyyy.Entity.Role;
import com.example.yyyyyy.Entity.User;
import com.example.yyyyyy.Entity.UserPrinciple;
import com.example.yyyyyy.Repository.RoleRepository;
import com.example.yyyyyy.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;


    @Override
   @Transactional
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                  .orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
        );
 
        return UserPrinciple.build(user);
    }
 

}
