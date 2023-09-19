package com.example.yyyyyy.Services;

import com.example.yyyyyy.Entity.Role;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

public interface UserDetailsService {
	UserDetails loadUserByUsername(String username);
    public Set<Role> getRolesByUsername(String username);
}
