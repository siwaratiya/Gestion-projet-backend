package com.example.yyyyyy.Repository;

import com.example.yyyyyy.Entity.Role;
import com.example.yyyyyy.Entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName roleNam);
   // Role findByName(RoleName roleName);

}
