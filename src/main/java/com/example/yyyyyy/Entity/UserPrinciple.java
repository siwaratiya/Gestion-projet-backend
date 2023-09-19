package com.example.yyyyyy.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;


public class UserPrinciple implements UserDetails {
  private static final long serialVersionUID = 1L;
 
  private Long id;
 
    private String name;
 
    private String username;
 
    private String email;
 
    @JsonIgnore
    private String password;

    private Boolean etat;
 
    private Collection<? extends GrantedAuthority> authorities;
 
    public UserPrinciple(Long id, String name,
                         String username, String email, String password, Boolean etat, Set<Role> roles,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.etat=etat;
        this.roles=roles;
    }
 
    public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());
 
        return new UserPrinciple(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getEtat(),
                user.getRoles(),
                authorities
        );
    }
 
    public Long getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public String getEmail() {
        return email;
    }
 
    @Override
    public String getUsername() {
        return username;
    }
 
    @Override
    public String getPassword() {
        return password;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    private Set<Role> roles = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role:this.roles) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getName().name());
            authorities.add(authority);
        }
        return authorities;
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}
